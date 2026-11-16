package removecoveredintervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveCoveredIntervalsTest {
    @Test
    fun standardExample() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(3, 6), intArrayOf(2, 8))
        assertEquals(2, Solution().removeCoveredIntervals(intervals))
    }

    @Test
    fun identicalIntervals() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(1, 4), intArrayOf(1, 4))
        assertEquals(1, Solution().removeCoveredIntervals(intervals))
    }

    @Test
    fun sameLeftEndpoint() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(1, Solution().removeCoveredIntervals(intervals))
    }

    @Test
    fun negativeEndpoints() {
        val intervals = arrayOf(intArrayOf(-5, -1), intArrayOf(-4, -2), intArrayOf(-3, 0))
        assertEquals(0, Solution().removeCoveredIntervals(intervals))
    }
}
