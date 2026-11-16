package longestsubsequencewithlimitedsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubsequenceWithLimitedSumTest {
    @Test
    fun standardExample() {
        val nums = intArrayOf(4, 5, 2, 1)
        assertArrayEquals(intArrayOf(2, 3, 4), Solution().answerQueries(nums, intArrayOf(3, 10, 21)))
    }

    @Test
    fun queriesCanBeBelowTheSmallestValue() {
        assertArrayEquals(
            intArrayOf(0, 1, 1, 3),
            Solution().answerQueries(intArrayOf(1, 2, 3), intArrayOf(0, 1, 2, 6))
        )
    }

    @Test
    fun upperBoundIncludesAllEqualPrefixSums() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 3),
            Solution().answerQueries(intArrayOf(2, 2, 2), intArrayOf(2, 4, 6, 7))
        )
    }
}
