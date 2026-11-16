package minimumcosttoequalizearraysusingswaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToEqualizeArraysUsingSwapsTest {
    private val solution = Solution()

    @Test
    fun alreadyEqual() {
        assertEquals(0, solution.minCost(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun permutationsNeedNoSwaps() {
        assertEquals(0, solution.minCost(intArrayOf(1, 2, 3, 4), intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(1, solution.minCost(intArrayOf(1, 1, 1, 2), intArrayOf(1, 2, 2, 2)))
    }

    @Test
    fun impossibleParity() {
        assertEquals(-1, solution.minCost(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun negativeValues() {
        assertEquals(1, solution.minCost(intArrayOf(-1, -1, -1, 2), intArrayOf(-1, 2, 2, 2)))
    }
}
