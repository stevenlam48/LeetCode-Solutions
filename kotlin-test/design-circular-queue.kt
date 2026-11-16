package designcircularqueue

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignCircularQueueTest {
    @Test
    fun leetCodeExample() {
        val queue = MyCircularQueue(3)
        assertTrue(queue.enQueue(1))
        assertTrue(queue.enQueue(2))
        assertTrue(queue.enQueue(3))
        assertFalse(queue.enQueue(4))
        assertEquals(3, queue.Rear())
        assertTrue(queue.isFull())
        assertTrue(queue.deQueue())
        assertTrue(queue.enQueue(4))
        assertEquals(4, queue.Rear())
    }

    @Test
    fun emptyQueueOperations() {
        val queue = MyCircularQueue(2)
        assertTrue(queue.isEmpty())
        assertFalse(queue.isFull())
        assertFalse(queue.deQueue())
        assertEquals(-1, queue.Front())
        assertEquals(-1, queue.Rear())
    }

    @Test
    fun fifoOrderAcrossWrapAround() {
        val queue = MyCircularQueue(2)
        queue.enQueue(10)
        queue.enQueue(20)
        assertEquals(10, queue.Front())
        queue.deQueue()
        queue.enQueue(30)
        assertEquals(20, queue.Front())
        queue.deQueue()
        assertEquals(30, queue.Front())
        assertEquals(30, queue.Rear())
    }

    @Test
    fun singleCapacityAndNegativeValues() {
        val queue = MyCircularQueue(1)
        assertTrue(queue.enQueue(-1))
        assertFalse(queue.enQueue(2))
        assertEquals(-1, queue.Front())
        assertEquals(-1, queue.Rear())
        assertTrue(queue.deQueue())
        assertTrue(queue.isEmpty())
    }
}
