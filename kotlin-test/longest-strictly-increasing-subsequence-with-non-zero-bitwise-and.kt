package longeststrictlyincreasingsubsequencewithnonzerobitwiseand

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestStrictlyIncreasingSubsequenceWithNonZeroBitwiseAndTest {
    @Test
    fun powersOfTwoRequireSharedLowerBits() {
        assertEquals(2, Solution().longestSubsequence(intArrayOf(1, 2, 3, 4, 8)))
    }

    @Test
    fun allOddValuesShareTheLowestBit() {
        assertEquals(4, Solution().longestSubsequence(intArrayOf(1, 3, 5, 7)))
    }

    @Test
    fun descendingPowersHaveNoLongerChain() {
        assertEquals(1, Solution().longestSubsequence(intArrayOf(8, 4, 2, 1)))
    }

    @Test
    fun bestChainUsesTheSecondBit() {
        assertEquals(4, Solution().longestSubsequence(intArrayOf(5, 3, 6, 7, 10)))
    }
}
