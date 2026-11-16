package longestsubarraywithatmostkdistinctprimefactors

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubarrayWithAtMostKDistinctPrimeFactorsTest {
    @Test
    fun onlyTwoConsecutivePrimesFit() {
        assertEquals(2, Solution().longestSubarray(intArrayOf(2, 3, 5, 7), 2))
    }

    @Test
    fun compositeNumbersSharePrimeFactors() {
        assertEquals(1, Solution().longestSubarray(intArrayOf(6, 10, 15), 2))
    }

    @Test
    fun onesContributeNoPrimeFactors() {
        assertEquals(5, Solution().longestSubarray(intArrayOf(1, 1, 2, 1, 1), 1))
    }

    @Test
    fun enoughRoomForEveryFactor() {
        assertEquals(3, Solution().longestSubarray(intArrayOf(6, 10, 15), 3))
    }
}
