package shortestpathinbinarymatrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathInBinaryMatrixTest {
    @Test
    fun usesDiagonalMove() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        assertEquals(2, Solution().shortestPathBinaryMatrix(grid))
    }

    @Test
    fun walksAroundObstacles() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
        )
        assertEquals(4, Solution().shortestPathBinaryMatrix(grid))
    }

    @Test
    fun returnsMinusOneWhenStartIsBlocked() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
        )
        assertEquals(-1, Solution().shortestPathBinaryMatrix(grid))
    }

    @Test
    fun handlesSingleCell() {
        assertEquals(1, Solution().shortestPathBinaryMatrix(arrayOf(intArrayOf(0))))
        assertEquals(-1, Solution().shortestPathBinaryMatrix(arrayOf(intArrayOf(1))))
    }

    @Test
    fun takesDiagonalShortcutInOpenGrid() {
        val grid = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(2, Solution().shortestPathBinaryMatrix(grid))
    }
}
