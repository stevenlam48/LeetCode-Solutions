package removeinterval

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveIntervalTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val intervals = arrayOf(intArrayOf(0, 2), intArrayOf(3, 4), intArrayOf(5, 7))
        val result = solution.removeInterval(intervals, intArrayOf(1, 6))
        assertEquals(2, result.size)
        assertArrayEquals(intArrayOf(0, 1), result[0])
        assertArrayEquals(intArrayOf(6, 7), result[1])
    }

    @Test
    fun testExample2() {
        val intervals = arrayOf(intArrayOf(0, 5))
        val result = solution.removeInterval(intervals, intArrayOf(2, 3))
        assertEquals(2, result.size)
        assertArrayEquals(intArrayOf(0, 2), result[0])
        assertArrayEquals(intArrayOf(3, 5), result[1])
    }

    @Test
    fun testFullRemoval() {
        val intervals = arrayOf(intArrayOf(0, 5))
        val result = solution.removeInterval(intervals, intArrayOf(0, 5))
        assertEquals(0, result.size)
    }

    @Test
    fun testNoOverlap() {
        val intervals = arrayOf(intArrayOf(1, 2))
        val result = solution.removeInterval(intervals, intArrayOf(3, 4))
        assertEquals(1, result.size)
        assertArrayEquals(intArrayOf(1, 2), result[0])
    }

    @Test
    fun testEmptyIntervals() {
        val result = solution.removeInterval(arrayOf(), intArrayOf(1, 2))
        assertEquals(0, result.size)
    }
}
