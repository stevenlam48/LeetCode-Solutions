package splitarrayintomaximumnumberofsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SplitArrayIntoMaximumNumberOfSubarraysTest {
    @Test
    fun alternatingZeroAndNonZeroValuesGiveThreeSubarrays() {
        assertEquals(3, Solution().maxSubarrays(intArrayOf(1, 0, 2, 0, 1, 2)))
    }

    @Test
    fun greedySplitFindsTwoZeroScoreSubarrays() {
        assertEquals(2, Solution().maxSubarrays(intArrayOf(2, 3, 1, 0)))
    }

    @Test
    fun positiveTotalAndScoreRequiresOneSubarray() {
        assertEquals(1, Solution().maxSubarrays(intArrayOf(5, 5, 5)))
    }

    @Test
    fun separateZeroesEndTwoSubarrays() {
        assertEquals(2, Solution().maxSubarrays(intArrayOf(7, 0, 7, 0, 7)))
    }

    @Test
    fun singleZeroHasOneSubarray() {
        assertEquals(1, Solution().maxSubarrays(intArrayOf(0)))
    }
}
