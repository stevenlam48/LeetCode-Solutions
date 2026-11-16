package nonoverlappingintervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NonOverlappingIntervalsTest {
    @Test
    fun example1() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 3),
        )
        assertEquals(1, Solution().eraseOverlapIntervals(intervals))
    }

    @Test
    fun example2() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 2),
        )
        assertEquals(2, Solution().eraseOverlapIntervals(intervals))
    }

    @Test
    fun touchingIntervalsDoNotOverlap() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
        )
        assertEquals(0, Solution().eraseOverlapIntervals(intervals))
    }

    @Test
    fun chainOfOverlaps() {
        val intervals = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(3, 5),
        )
        assertEquals(2, Solution().eraseOverlapIntervals(intervals))
    }
}
