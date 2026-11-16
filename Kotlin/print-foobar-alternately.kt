package printfoobaralternately

import java.util.concurrent.locks.ReentrantLock

// Time:  O(n)
// Space: O(1)

class FooBar(private val n: Int) {
    private var curr = false
    private val lock = ReentrantLock()
    private val cond = lock.newCondition()

    fun foo(printFoo: () -> Unit) {
        for (i in 0 until n) {
            lock.lock()
            try {
                while (curr) {
                    cond.await()
                }
                curr = true
                printFoo()
                cond.signalAll()
            } finally {
                lock.unlock()
            }
        }
    }

    fun bar(printBar: () -> Unit) {
        for (i in 0 until n) {
            lock.lock()
            try {
                while (!curr) {
                    cond.await()
                }
                curr = false
                printBar()
                cond.signalAll()
            } finally {
                lock.unlock()
            }
        }
    }
}
