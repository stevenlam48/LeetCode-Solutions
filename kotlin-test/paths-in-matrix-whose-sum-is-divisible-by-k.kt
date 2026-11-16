package pathsinmatrixwhosesumisdivisiblebyk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PathsInMatrixWhoseSumIsDivisibleByKTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(5, 2, 4),
            intArrayOf(3, 0, 5),
            intArrayOf(0, 7, 2)
        )
        assertEquals(2, solution.numberOfPaths(grid, 3))
    }

    @Test
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(0, 0))
        assertEquals(1, solution.numberOfPaths(grid, 5))
    }

    @Test
    fun testKEqualsOne() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(2, solution.numberOfPaths(grid, 1))
    }

    @Test
    fun testOnePathDivisible() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(1, solution.numberOfPaths(grid, 2))
    }
}
