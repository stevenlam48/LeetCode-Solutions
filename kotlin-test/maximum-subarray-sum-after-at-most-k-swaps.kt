package maximumsubarraysumafteratmostkswaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarraySumAfterAtMostKSwapsTest {
    @Test
    fun oneSwapImprovesSubarray() {
        val solution = Solution()
        assertEquals(13L, solution.maxSum(intArrayOf(3, -2, 4, -5, 6), 1))
    }

    @Test
    fun zeroSwapsIsStandardMaximumSubarray() {
        val solution = Solution()
        assertEquals(5L, solution.maxSum(intArrayOf(1, -2, 3, -4, 5), 0))
    }

    @Test
    fun allNegativesReturnsLargestElement() {
        val solution = Solution()
        assertEquals(-1L, solution.maxSum(intArrayOf(-5, -1, -3), 2))
    }

    @Test
    fun enoughSwapsRemovesAllNegatives() {
        val solution = Solution()
        assertEquals(9L, solution.maxSum(intArrayOf(1, -2, 3, -4, 5), 2))
    }

    @Test
    fun swapCanUseEitherOutsideElement() {
        val solution = Solution()
        assertEquals(4L, solution.maxSum(intArrayOf(2, -1, 2), 1))
    }
}
