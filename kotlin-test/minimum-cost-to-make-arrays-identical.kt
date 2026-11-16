package minimumcosttomakearraysidentical

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMakeArraysIdenticalTest {
    private val solution = Solution()

    @Test
    fun sortingIsWorthItsCost() {
        assertEquals(4L, solution.minCost(intArrayOf(4, 3, 2), intArrayOf(1, 4, 3), 3L))
    }

    @Test
    fun directChangesAreCheaper() {
        assertEquals(5L, solution.minCost(intArrayOf(4, 3, 2), intArrayOf(1, 4, 3), 10L))
    }

    @Test
    fun alreadyIdentical() {
        assertEquals(0L, solution.minCost(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), 0L))
    }

    @Test
    fun negativeValues() {
        assertEquals(2L, solution.minCost(intArrayOf(-3, 2), intArrayOf(-1, 2), 0L))
    }
}
