package designboundedblockingqueue

// Time:  O(n)
// Space: O(1)
import java.util.ArrayDeque
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class BoundedBlockingQueue(private val cap: Int) {
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()
    private val queue = ArrayDeque<Int>()

    fun enqueue(element: Int) {
        lock.withLock {
            while (queue.size == cap) {
                condition.await()
            }
            queue.addLast(element)
        }
        lock.withLock { condition.signalAll() }
    }

    fun dequeue(): Int {
        val element: Int
        lock.withLock {
            while (queue.isEmpty()) {
                condition.await()
            }
            element = queue.removeFirst()
        }
        lock.withLock { condition.signalAll() }
        return element
    }

    fun size(): Int = lock.withLock { queue.size }
}
