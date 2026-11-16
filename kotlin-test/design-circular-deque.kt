package designcirculardeque

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignCircularDequeTest {
    @Test
    fun leetCodeExample() {
        val deque = MyCircularDeque(3)
        assertTrue(deque.insertLast(1))
        assertTrue(deque.insertLast(2))
        assertTrue(deque.insertFront(3))
        assertFalse(deque.insertFront(4))
        assertEquals(2, deque.getRear())
        assertTrue(deque.isFull())
        assertTrue(deque.deleteLast())
        assertTrue(deque.insertFront(4))
        assertEquals(4, deque.getFront())
    }

    @Test
    fun emptyDequeOperations() {
        val deque = MyCircularDeque(2)
        assertTrue(deque.isEmpty())
        assertFalse(deque.isFull())
        assertEquals(-1, deque.getFront())
        assertEquals(-1, deque.getRear())
        assertFalse(deque.deleteFront())
        assertFalse(deque.deleteLast())
    }

    @Test
    fun frontAndBackWrapAround() {
        val deque = MyCircularDeque(3)
        assertTrue(deque.insertFront(2))
        assertTrue(deque.insertLast(3))
        assertTrue(deque.insertLast(4))
        assertEquals(2, deque.getFront())
        assertEquals(4, deque.getRear())
        assertTrue(deque.deleteFront())
        assertTrue(deque.insertFront(1))
        assertEquals(1, deque.getFront())
        assertTrue(deque.deleteLast())
        assertEquals(3, deque.getRear())
    }

    @Test
    fun singleCapacity() {
        val deque = MyCircularDeque(1)
        assertTrue(deque.insertLast(-5))
        assertFalse(deque.insertFront(7))
        assertEquals(-5, deque.getFront())
        assertEquals(-5, deque.getRear())
        assertTrue(deque.deleteFront())
        assertTrue(deque.insertFront(7))
        assertEquals(7, deque.getRear())
    }
}
