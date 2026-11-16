package numberoflongestincreasingsubsequence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfLongestIncreasingSubsequenceTest {
    @Test
    fun standardExample() {
        val solution = Solution()
        assertEquals(2, solution.findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7)))
    }

    @Test
    fun allEqualValues() {
        val solution = Solution()
        assertEquals(5, solution.findNumberOfLIS(intArrayOf(2, 2, 2, 2, 2)))
    }

    @Test
    fun emptyArray() {
        val solution = Solution()
        assertEquals(0, solution.findNumberOfLIS(intArrayOf()))
    }

    @Test
    fun duplicateBranchesAndNegativeValues() {
        val solution = Solution()
        assertEquals(2, solution.findNumberOfLIS(intArrayOf(-1, 0, 0, 1)))
    }
}
