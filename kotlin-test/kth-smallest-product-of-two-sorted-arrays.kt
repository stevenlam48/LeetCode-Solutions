package kthsmallestproductoftwosortedarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestProductOfTwoSortedArraysTest {
    @Test
    fun mixedSignsExample() {
        assertEquals(15L, Solution().kthSmallestProduct(intArrayOf(2, 5), intArrayOf(-4, -1, 0, 3), 8))
        assertEquals(-20L, Solution().kthSmallestProduct(intArrayOf(2, 5), intArrayOf(-4, -1, 0, 3), 1))
    }

    @Test
    fun zerosOccupyMiddleRanks() {
        val solution = Solution()
        assertEquals(0L, solution.kthSmallestProduct(intArrayOf(-4, -2, 0, 3), intArrayOf(2, 4), 6))
        assertEquals(-8L, solution.kthSmallestProduct(intArrayOf(-4, -2, 0, 3), intArrayOf(2, 4), 3))
    }

    @Test
    fun negativeProductsWithBothArraysNegative() {
        assertEquals(12L, Solution().kthSmallestProduct(intArrayOf(-4, -2), intArrayOf(-5, -3), 3))
    }

    @Test
    fun singleZeroProduct() {
        assertEquals(0L, Solution().kthSmallestProduct(intArrayOf(0), intArrayOf(-100, 100), 1))
        assertEquals(0L, Solution().kthSmallestProduct(intArrayOf(0), intArrayOf(-100, 100), 2))
    }
}
