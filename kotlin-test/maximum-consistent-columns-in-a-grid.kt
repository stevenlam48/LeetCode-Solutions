package maximumconsistentcolumnsinagrid

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumConsistentColumnsInAGridTest {
    private val solution = Solution()

    @Test
    fun consecutiveColumnsWithinLimit() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(3, solution.maxConsistentColumns(grid, 1))
    }

    @Test
    fun nonAdjacentCompatibleColumns() {
        val grid = arrayOf(
            intArrayOf(1, 10, 2),
            intArrayOf(1, 10, 2),
            intArrayOf(1, 10, 2)
        )
        assertEquals(2, solution.maxConsistentColumns(grid, 1))
    }

    @Test
    fun zeroLimitRejectsDifferentValues() {
        val grid = arrayOf(
            intArrayOf(1, 1, 2),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 3, 2)
        )
        assertEquals(1, solution.maxConsistentColumns(grid, 0))
    }

    @Test
    fun singleColumn() {
        val grid = arrayOf(intArrayOf(4), intArrayOf(9), intArrayOf(-2))
        assertEquals(1, solution.maxConsistentColumns(grid, 0))
    }
}
