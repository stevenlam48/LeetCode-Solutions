package maximumsubarraysumafteroneoperation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarraySumAfterOneOperationTest {
    @Test
    fun squareNegativeInsideSubarray() {
        val solution = Solution()
        assertEquals(17, solution.maxSumAfterOperation(intArrayOf(2, -1, -4, -3)))
    }

    @Test
    fun squarePositiveAtEnd() {
        val solution = Solution()
        assertEquals(20, solution.maxSumAfterOperation(intArrayOf(2, -1, -4, 3)))
    }

    @Test
    fun singleElement() {
        val solution = Solution()
        assertEquals(25, solution.maxSumAfterOperation(intArrayOf(5)))
    }

    @Test
    fun allNegativeValues() {
        val solution = Solution()
        assertEquals(9, solution.maxSumAfterOperation(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun zeros() {
        val solution = Solution()
        assertEquals(0, solution.maxSumAfterOperation(intArrayOf(0, 0)))
    }
}
