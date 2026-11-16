package maximumsubarraysumaftermultiplier

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarraySumAfterMultiplierTest {
    @Test
    fun multiplyingLastElement() {
        val solution = Solution()
        assertEquals(8L, solution.maxSubarraySum(intArrayOf(1, 2, -3, 4), 2))
    }

    @Test
    fun multiplyingPositiveElementAfterNegative() {
        val solution = Solution()
        assertEquals(6L, solution.maxSubarraySum(intArrayOf(1, -2, 3), 2))
    }

    @Test
    fun allNegativeValues() {
        val solution = Solution()
        assertEquals(-1L, solution.maxSubarraySum(intArrayOf(-3, -2), 2))
    }

    @Test
    fun operationCanOccurAtEitherEnd() {
        val solution = Solution()
        assertEquals(27L, solution.maxSubarraySum(intArrayOf(5, -1, 5), 3))
    }
}
