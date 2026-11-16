package designboundedblockingqueue

import java.time.Duration
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignBoundedBlockingQueueTest {
    @Test
    fun fifoOperationsAndSize() {
        val queue = BoundedBlockingQueue(2)
        assertEquals(0, queue.size())
        queue.enqueue(1)
        queue.enqueue(2)
        assertEquals(2, queue.size())
        assertEquals(1, queue.dequeue())
        queue.enqueue(3)
        assertEquals(2, queue.dequeue())
        assertEquals(3, queue.dequeue())
        assertEquals(0, queue.size())
    }

    @Test
    fun enqueueWaitsWhenFull() {
        assertTimeoutPreemptively(Duration.ofSeconds(5)) {
            val queue = BoundedBlockingQueue(1)
            queue.enqueue(1)
            val started = CountDownLatch(1)
            val worker = thread {
                started.countDown()
                queue.enqueue(2)
            }
            assertTrue(started.await(1, TimeUnit.SECONDS))
            assertEquals(1, queue.dequeue())
            worker.join()
            assertEquals(2, queue.dequeue())
        }
    }

    @Test
    fun dequeueWaitsWhenEmpty() {
        assertTimeoutPreemptively(Duration.ofSeconds(5)) {
            val queue = BoundedBlockingQueue(1)
            val result = AtomicInteger()
            val started = CountDownLatch(1)
            val worker = thread {
                started.countDown()
                result.set(queue.dequeue())
            }
            assertTrue(started.await(1, TimeUnit.SECONDS))
            queue.enqueue(42)
            worker.join()
            assertEquals(42, result.get())
        }
    }
}
