package rleiterator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RleIteratorTest {
    @Test
    fun leetCodeExample() {
        val iterator = RLEIterator(intArrayOf(3, 8, 0, 9, 2, 5))
        assertEquals(8, iterator.next(2))
        assertEquals(8, iterator.next(1))
        assertEquals(5, iterator.next(1))
        assertEquals(-1, iterator.next(2))
    }

    @Test
    fun singleRun() {
        val iterator = RLEIterator(intArrayOf(1, 1))
        assertEquals(1, iterator.next(1))
        assertEquals(-1, iterator.next(1))
    }

    @Test
    fun skipsZeroCountRuns() {
        val iterator = RLEIterator(intArrayOf(0, 3, 2, 4))
        assertEquals(4, iterator.next(1))
        assertEquals(4, iterator.next(1))
        assertEquals(-1, iterator.next(1))
    }

    @Test
    fun exhaustingAllElements() {
        val iterator = RLEIterator(intArrayOf(2, 7))
        assertEquals(-1, iterator.next(5))
        assertEquals(-1, iterator.next(1))
    }

    @Test
    fun consumesAcrossRuns() {
        val iterator = RLEIterator(intArrayOf(2, 1, 1, 2, 1, 3))
        assertEquals(1, iterator.next(2))
        assertEquals(3, iterator.next(2))
        assertEquals(-1, iterator.next(1))
    }
}
