package maximumsumofalternatingsubsequencewithdistanceatleastk
// Time:  O(nlogn)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfAlternatingSubsequenceWithDistanceAtLeastKTest {
    @Test
    fun singleElement() {
        assertEquals(7L, Solution().maxAlternatingSum(intArrayOf(7), 1))
    }

    @Test
    fun increasingValues() {
        assertEquals(5L, Solution().maxAlternatingSum(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun alternatesAcrossFourElements() {
        assertEquals(13L, Solution().maxAlternatingSum(intArrayOf(1, 5, 3, 4), 1))
    }

    @Test
    fun enforcesMinimumDistance() {
        assertEquals(9L, Solution().maxAlternatingSum(intArrayOf(1, 5, 3, 4), 2))
    }

    @Test
    fun duplicateValuesCannotBeAdjacentInSubsequence() {
        assertEquals(2L, Solution().maxAlternatingSum(intArrayOf(2, 2, 2), 1))
    }

    @Test
    fun negativeSingleElement() {
        assertEquals(-7L, Solution().maxAlternatingSum(intArrayOf(-7), 3))
    }
}
