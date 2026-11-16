package longestcontinuousincreasingsubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestContinuousIncreasingSubsequenceTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.findLengthOfLCIS(intArrayOf(1, 3, 5, 4, 7)))
    }

    @Test
    fun decreasingInput() {
        assertEquals(1, solution.findLengthOfLCIS(intArrayOf(2, 2, 2, 2, 2)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.findLengthOfLCIS(intArrayOf()))
    }

    @Test
    fun negatives() {
        assertEquals(3, solution.findLengthOfLCIS(intArrayOf(-5, -4, -3, -3, -2)))
    }
}
