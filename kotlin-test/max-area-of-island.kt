package maxareaofisland

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxAreaOfIslandTest {
    private val solution = Solution()

    @Test
    fun findsLargestIslandInExample() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
        )
        assertEquals(6, solution.maxAreaOfIsland(grid))
    }

    @Test
    fun returnsZeroForAllWater() {
        assertEquals(0, solution.maxAreaOfIsland(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun countsEntireSingleIslandGrid() {
        assertEquals(6, solution.maxAreaOfIsland(Array(2) { IntArray(3) { 1 } }))
    }

    @Test
    fun doesNotJoinDiagonalIslands() {
        val grid = arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))
        assertEquals(1, solution.maxAreaOfIsland(grid))
    }

    @Test
    fun marksVisitedLandAsNegative() {
        val grid = arrayOf(intArrayOf(1, 0))
        solution.maxAreaOfIsland(grid)
        assertEquals(-1, grid[0][0])
    }
}
