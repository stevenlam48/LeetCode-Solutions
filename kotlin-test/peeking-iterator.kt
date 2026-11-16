package peekingiterator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PeekingIteratorTest {
    @Test
    fun testExample() {
        val it = PeekingIterator(intArrayOf(1, 2, 3))
        assertEquals(1, it.peek())
        assertEquals(1, it.next())
        assertEquals(2, it.next())
        assertTrue(it.hasNext())
        assertEquals(3, it.next())
        assertFalse(it.hasNext())
    }

    @Test
    fun testRepeatedPeek() {
        val it = PeekingIterator(intArrayOf(4, 5))
        assertEquals(4, it.peek())
        assertEquals(4, it.peek())
        assertEquals(4, it.next())
        assertEquals(5, it.peek())
        assertEquals(5, it.next())
        assertFalse(it.hasNext())
    }

    @Test
    fun testSingleElement() {
        val it = PeekingIterator(intArrayOf(7))
        assertTrue(it.hasNext())
        assertEquals(7, it.peek())
        assertEquals(7, it.next())
        assertFalse(it.hasNext())
    }
}
