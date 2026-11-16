package islandperimeter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IslandPerimeterTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 0, 0)
        )
        assertEquals(16, solution.islandPerimeter(grid))
    }

    @Test
    fun testSingleCell() {
        assertEquals(4, solution.islandPerimeter(arrayOf(intArrayOf(1))))
    }

    @Test
    fun testSingleRow() {
        assertEquals(4, solution.islandPerimeter(arrayOf(intArrayOf(1, 0))))
        assertEquals(6, solution.islandPerimeter(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun testNoLand() {
        assertEquals(
            0,
            solution.islandPerimeter(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))
        )
    }

    @Test
    fun testFullBlock() {
        assertEquals(
            8,
            solution.islandPerimeter(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)))
        )
    }
}
