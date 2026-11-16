package numberofdistinctislands

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfDistinctIslandsTest {
    private val solution = Solution()

    @Test
    fun countsTranslatedRectanglesAsOneIsland() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 1),
            intArrayOf(0, 0, 0, 1, 1)
        )
        assertEquals(1, solution.numDistinctIslands(grid))
    }

    @Test
    fun countsThreeDifferentShapes() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0, 1, 1),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1),
            intArrayOf(1, 1, 0, 1, 1)
        )
        assertEquals(3, solution.numDistinctIslands(grid))
    }

    @Test
    fun treatsRotatedShapesAsDifferent() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0, 1, 0),
            intArrayOf(1, 0, 0, 1, 1)
        )
        assertEquals(2, solution.numDistinctIslands(grid))
    }

    @Test
    fun returnsZeroWithoutLand() {
        val grid = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(0, solution.numDistinctIslands(grid))
    }
}
