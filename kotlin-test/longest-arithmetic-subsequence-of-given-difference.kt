package longestarithmeticsubsequenceofgivendifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestArithmeticSubsequenceOfGivenDifferenceTest {
    @Test
    fun consecutiveSequence() {
        assertEquals(4, Solution().longestSubsequence(intArrayOf(1, 2, 3, 4), 1))
    }

    @Test
    fun noPairWithDifference() {
        assertEquals(1, Solution().longestSubsequence(intArrayOf(1, 3, 5, 7), 1))
    }

    @Test
    fun negativeDifference() {
        assertEquals(
            4,
            Solution().longestSubsequence(intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1), -2)
        )
    }

    @Test
    fun repeatedValues() {
        assertEquals(2, Solution().longestSubsequence(intArrayOf(1, 2), 1))
        assertEquals(1, Solution().longestSubsequence(intArrayOf(1, 2), 0))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().longestSubsequence(intArrayOf(7), 3))
    }
}
