package numberofdistinctislandsii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfDistinctIslandsIITest {
    private val solution = Solution()

    @Test
    fun countsTranslatedRectanglesAsOneIsland() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 1),
            intArrayOf(0, 0, 0, 1, 1)
        )
        assertEquals(1, solution.numDistinctIslands2(grid))
    }

    @Test
    fun countsRotatedAndReflectedShapesAsOneIsland() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 0, 0, 1, 1)
        )
        assertEquals(1, solution.numDistinctIslands2(grid))
    }

    @Test
    fun separatesNonCongruentShapes() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 0, 0, 1, 0)
        )
        assertEquals(3, solution.numDistinctIslands2(grid))
    }

    @Test
    fun countsDisconnectedSingletonsAsOneIsland() {
        val grid = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(1, solution.numDistinctIslands2(grid))
    }

    @Test
    fun returnsZeroWithoutLand() {
        val grid = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(0, solution.numDistinctIslands2(grid))
    }
}
