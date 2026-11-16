package minimumcostpathwithteleportations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostPathWithTeleportationsTest {
    @Test
    fun withoutTeleportation() {
        assertEquals(6, Solution().minCost(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 0))
    }

    @Test
    fun teleportationSkipsExpensiveRow() {
        val grid = arrayOf(intArrayOf(1, 1, 1), intArrayOf(100, 100, 100), intArrayOf(1, 1, 1))
        assertEquals(103, Solution().minCost(grid, 0))
        assertEquals(0, Solution().minCost(grid, 1))
    }

    @Test
    fun singleCell() {
        assertEquals(0, Solution().minCost(arrayOf(intArrayOf(5)), 0))
    }
}
