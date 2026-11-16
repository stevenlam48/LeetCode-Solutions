package pathwithmaximumminimumvalue

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PathWithMaximumMinimumValueTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(5, 4, 5),
            intArrayOf(1, 2, 6),
            intArrayOf(7, 4, 6)
        )
        assertEquals(4, solution.maximumMinimumPath(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(2, 2, 1, 2, 2, 2),
            intArrayOf(1, 2, 2, 2, 1, 2)
        )
        assertEquals(2, solution.maximumMinimumPath(grid))
    }

    @Test
    fun testSingleCell() {
        val grid = arrayOf(intArrayOf(1))
        assertEquals(1, solution.maximumMinimumPath(grid))
    }

    @Test
    fun testTwoCells() {
        val grid = arrayOf(intArrayOf(3, 9))
        assertEquals(3, solution.maximumMinimumPath(grid))
    }
}
