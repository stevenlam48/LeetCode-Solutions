package maxpairsuminanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxPairSumInAnArrayTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        assertEquals(88, solution.maxSum(intArrayOf(51, 71, 17, 24, 42)))
    }

    @Test
    fun computesSecondExample() {
        assertEquals(-1, solution.maxSum(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun keepsLargestEarlierValueWithDigit() {
        assertEquals(198, solution.maxSum(intArrayOf(99, 98, 99)))
    }

    @Test
    fun returnsMinusOneWithoutMatchingMaximumDigit() {
        assertEquals(-1, solution.maxSum(intArrayOf(19, 28, 37)))
    }

    @Test
    fun groupsZeroByMaximumDigitZero() {
        assertEquals(0, solution.maxSum(intArrayOf(0, 0)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(-1, solution.maxSum(intArrayOf()))
    }
}
