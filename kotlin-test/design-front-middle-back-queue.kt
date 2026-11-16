package designfrontmiddlebackqueue

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignFrontMiddleBackQueueTest {
    @Test
    fun leetCodeExample() {
        val queue = FrontMiddleBackQueue()
        queue.pushFront(1)
        queue.pushBack(2)
        queue.pushMiddle(3)
        queue.pushMiddle(4)
        assertEquals(1, queue.popFront())
        assertEquals(3, queue.popMiddle())
        assertEquals(4, queue.popMiddle())
        assertEquals(2, queue.popBack())
        assertEquals(-1, queue.popFront())
    }

    @Test
    fun emptyQueuePopsReturnMinusOne() {
        val queue = FrontMiddleBackQueue()
        assertEquals(-1, queue.popFront())
        assertEquals(-1, queue.popMiddle())
        assertEquals(-1, queue.popBack())
    }

    @Test
    fun evenAndOddMiddleSelection() {
        val queue = FrontMiddleBackQueue()
        queue.pushBack(1)
        queue.pushBack(2)
        queue.pushBack(3)
        queue.pushBack(4)
        assertEquals(2, queue.popMiddle())
        assertEquals(3, queue.popMiddle())
        assertEquals(1, queue.popMiddle())
        assertEquals(4, queue.popMiddle())
    }

    @Test
    fun mixedPushOperationsMaintainOrder() {
        val queue = FrontMiddleBackQueue()
        queue.pushMiddle(3)
        queue.pushFront(1)
        queue.pushBack(5)
        queue.pushMiddle(2)
        queue.pushMiddle(4)
        assertEquals(1, queue.popFront())
        assertEquals(5, queue.popBack())
        assertEquals(4, queue.popMiddle())
        assertEquals(2, queue.popFront())
        assertEquals(3, queue.popFront())
    }
}
