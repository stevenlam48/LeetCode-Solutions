package minimumpathcostinagrid

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MinimumPathCostInAGridTest {
    private val solution = Solution()

    @Test
    fun findsMinimumAcrossThreeRows() {
        val grid = arrayOf(
            intArrayOf(5, 3),
            intArrayOf(4, 0),
            intArrayOf(2, 1)
        )
        val moveCost = arrayOf(
            intArrayOf(9, 8),
            intArrayOf(1, 5),
            intArrayOf(10, 12),
            intArrayOf(18, 6),
            intArrayOf(2, 4),
            intArrayOf(14, 3)
        )
        assertEquals(17, solution.minPathCost(grid, moveCost))
    }

    @Test
    fun comparesAllStartingColumns() {
        val grid = arrayOf(
            intArrayOf(5, 1, 2),
            intArrayOf(4, 0, 3)
        )
        val moveCost = arrayOf(
            intArrayOf(12, 10, 15),
            intArrayOf(20, 23, 8),
            intArrayOf(21, 7, 1),
            intArrayOf(8, 1, 13),
            intArrayOf(9, 10, 25),
            intArrayOf(5, 3, 2)
        )
        assertEquals(6, solution.minPathCost(grid, moveCost))
    }

    @Test
    fun returnsSmallestValueForSingleRow() {
        assertEquals(2, solution.minPathCost(arrayOf(intArrayOf(7, 2, 9)), emptyArray()))
    }
}
