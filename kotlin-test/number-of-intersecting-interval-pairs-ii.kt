package numberofintersectingintervalpairsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfIntersectingIntervalPairsIITest {
    @Test
    fun countsIntersectingPair() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(5, 7))
        assertEquals(1L, Solution().countIntersectingIntervals(intervals))
    }

    @Test
    fun returnsZeroForEmptyOrDisjointIntervals() {
        assertEquals(0L, Solution().countIntersectingIntervals(emptyArray()))
        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))
        assertEquals(0L, Solution().countIntersectingIntervals(intervals))
    }

    @Test
    fun countsSharedEndpoints() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(3, 5), intArrayOf(5, 7))
        assertEquals(2L, Solution().countIntersectingIntervals(intervals))
    }

    @Test
    fun countsDuplicateAndNestedIntervals() {
        val duplicates = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2))
        assertEquals(3L, Solution().countIntersectingIntervals(duplicates))
        val nested = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 5))
        assertEquals(3L, Solution().countIntersectingIntervals(nested))
    }
}
