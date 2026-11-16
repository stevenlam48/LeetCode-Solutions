package zigzagiterator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ZigzagIteratorTest {
    private fun drain(it: ZigzagIterator): List<Int> {
        val result = ArrayList<Int>()
        while (it.hasNext()) {
            result.add(it.next())
        }
        return result
    }

    @Test
    fun example1() {
        val it = ZigzagIterator(intArrayOf(1, 2), intArrayOf(3, 4, 5, 6))
        assertEquals(listOf(1, 3, 2, 4, 5, 6), drain(it))
    }

    @Test
    fun equalLengths() {
        val it = ZigzagIterator(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertEquals(listOf(1, 4, 2, 5, 3, 6), drain(it))
    }

    @Test
    fun firstEmpty() {
        val it = ZigzagIterator(intArrayOf(), intArrayOf(1, 2))
        assertEquals(listOf(1, 2), drain(it))
    }

    @Test
    fun secondEmpty() {
        val it = ZigzagIterator(intArrayOf(1, 2), intArrayOf())
        assertEquals(listOf(1, 2), drain(it))
    }

    @Test
    fun bothEmpty() {
        val it = ZigzagIterator(intArrayOf(), intArrayOf())
        assertFalse(it.hasNext())
    }

    @Test
    fun hasNextTransitions() {
        val it = ZigzagIterator(intArrayOf(1), intArrayOf(2))
        assertTrue(it.hasNext())
        assertEquals(1, it.next())
        assertTrue(it.hasNext())
        assertEquals(2, it.next())
        assertFalse(it.hasNext())
    }
}
