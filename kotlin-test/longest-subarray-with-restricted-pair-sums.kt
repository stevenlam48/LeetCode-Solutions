package longestsubarraywithrestrictedpairsums

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubarrayWithRestrictedPairSumsTest {
    @Test
    fun singleElement() {
        assertEquals(1, Solution().maxSubarray(intArrayOf(5)))
    }

    @Test
    fun equalValuesCanBeKeptTogether() {
        assertEquals(3, Solution().maxSubarray(intArrayOf(1, 1, 1)))
    }

    @Test
    fun restrictedPairMovesTheLeftBoundary() {
        assertEquals(2, Solution().maxSubarray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun bestSubarrayNeedNotStartAtZero() {
        assertEquals(2, Solution().maxSubarray(intArrayOf(2, 4, 2)))
    }
}
