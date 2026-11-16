package maximumsubarraysumoffixedlengthafteratmostkswaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarraySumOfFixedLengthAfterAtMostKSwapsTest {
    @Test
    fun zeroSwapsSelectsBestWindow() {
        val solution = Solution()
        assertEquals(12L, solution.maxSum(intArrayOf(1, 2, 3, 4, 5), 3, 0))
    }

    @Test
    fun oneSwapUsesLargeOutsideValue() {
        val solution = Solution()
        assertEquals(20L, solution.maxSum(intArrayOf(10, 1, 1, 1, 9), 3, 1))
    }

    @Test
    fun twoSwapsInMiddleWindow() {
        val solution = Solution()
        assertEquals(21L, solution.maxSum(intArrayOf(10, 1, 1, 2, 9), 3, 2))
    }

    @Test
    fun allNegativeValues() {
        val solution = Solution()
        assertEquals(-5L, solution.maxSum(intArrayOf(-5, -2, -3, -4), 2, 1))
    }

    @Test
    fun duplicateValuesCanAchieveGlobalTopSum() {
        val solution = Solution()
        assertEquals(10L, solution.maxSum(intArrayOf(5, 1, 5, 1, 5), 2, 1))
    }

    @Test
    fun excessiveSwapCountIsCapped() {
        val solution = Solution()
        assertEquals(103L, solution.maxSum(intArrayOf(1, 100, 2, 3), 2, 10))
    }
}
