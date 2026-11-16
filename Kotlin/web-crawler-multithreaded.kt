package webcrawlermultithreaded

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock

// Time:  O(|V| + |E|)
// Space: O(|V|)

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 */
interface HtmlParser {
    fun getUrls(url: String): List<String>
}

class Solution {
    fun crawl(startUrl: String, htmlParser: HtmlParser): List<String> {
        q_.addLast(startUrl)
        val lookup = hashSetOf(startUrl)
        val workers = mutableListOf<Thread>()
        val worker = {
            while (true) {
                var fromUrl = ""
                m_.withLock {
                    while (q_.isEmpty()) {
                        cv_.await()
                    }
                    fromUrl = q_.removeFirst()
                    if (fromUrl.isNotEmpty()) {
                        ++workingCount_
                    }
                }
                if (fromUrl.isEmpty()) {
                    break
                }
                val name = hostname(fromUrl)
                for (toUrl in htmlParser.getUrls(fromUrl)) {
                    if (name != hostname(toUrl)) {
                        continue
                    }
                    m_.withLock {
                        if (toUrl !in lookup) {
                            lookup.add(toUrl)
                            q_.addLast(toUrl)
                            cv_.signalAll()
                        }
                    }
                }
                m_.withLock {
                    --workingCount_
                    if (q_.isEmpty() && workingCount_ == 0) {
                        cv_.signalAll()
                    }
                }
            }
        }
        repeat(NUMBER_OF_WORKERS) {
            workers.add(thread(start = false) { worker() })
        }
        for (t in workers) {
            t.start()
        }
        m_.withLock {
            while (!(q_.isEmpty() && workingCount_ == 0)) {
                cv_.await()
            }
            repeat(workers.size) {
                q_.addLast("")
            }
            cv_.signalAll()
        }
        for (t in workers) {
            t.join()
        }
        return lookup.toList()
    }

    private fun hostname(url: String): String {
        val scheme = "http://"
        val idx = url.indexOf('/', scheme.length)
        return if (idx == -1) url else url.substring(0, idx)
    }

    private val NUMBER_OF_WORKERS = 4
    private val q_ = ArrayDeque<String>()
    private var workingCount_ = 0
    private val m_ = ReentrantLock()
    private val cv_: Condition = m_.newCondition()
}
