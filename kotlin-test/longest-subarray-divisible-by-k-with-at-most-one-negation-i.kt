package longestsubarraydivisiblebykwithatmostonenegationi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubarrayDivisibleByKWithAtMostOneNegationITest {
    @Test
    fun negatingOneValueCanUseTheWholeArray() {
        assertEquals(4, Solution().longestSubarray(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun negativeInputCanBeNegated() {
        assertEquals(3, Solution().longestSubarray(intArrayOf(5, -1, 2), 4))
    }

    @Test
    fun noNegationIsNeeded() {
        assertEquals(3, Solution().longestSubarray(intArrayOf(2, 4, 3), 3))
    }

    @Test
    fun oddSumCannotBeFixedByNegation() {
        assertEquals(2, Solution().longestSubarray(intArrayOf(1, 1, 1), 2))
    }
}
