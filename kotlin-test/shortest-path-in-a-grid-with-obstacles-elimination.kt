package shortestpathinagridwithobstacleselimination

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathInAGridWithObstaclesEliminationTest {
    @Test
    fun findsPathUsingOneElimination() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(4, Solution().shortestPath(grid, 1))
    }

    @Test
    fun eliminatesObstacleWhenNecessary() {
        assertEquals(2, Solution().shortestPath(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), 1))
        assertEquals(-1, Solution().shortestPath(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), 0))
    }

    @Test
    fun cannotCrossFullWall() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0)
        )
        assertEquals(-1, Solution().shortestPath(grid, 1))
    }

    @Test
    fun handlesSingleCell() {
        assertEquals(0, Solution().shortestPath(arrayOf(intArrayOf(0)), 0))
    }

    @Test
    fun handlesSingleRow() {
        assertEquals(2, Solution().shortestPath(arrayOf(intArrayOf(0, 1, 0)), 1))
        assertEquals(-1, Solution().shortestPath(arrayOf(intArrayOf(0, 1, 0)), 0))
    }
}
