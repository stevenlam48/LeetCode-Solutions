package sumofremotenessofallcells

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfRemotenessOfAllCellsTest {
    private val solution = Solution()

    @Test
    fun oneConnectedComponent() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(0L, solution.sumRemoteness(grid))
    }

    @Test
    fun twoIsolatedCells() {
        val grid = arrayOf(intArrayOf(1, -1), intArrayOf(-1, 2))
        assertEquals(3L, solution.sumRemoteness(grid))
    }

    @Test
    fun componentsWithDifferentSizes() {
        val grid = arrayOf(intArrayOf(1, 2, -1), intArrayOf(4, -1, 5))
        assertEquals(22L, solution.sumRemoteness(grid))
    }

    @Test
    fun allCellsBlocked() {
        val grid = arrayOf(intArrayOf(-1, -1), intArrayOf(-1, -1))
        assertEquals(0L, solution.sumRemoteness(grid))
    }
}
