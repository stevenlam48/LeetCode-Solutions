package minimumnumberofvisitedcellsinagrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumNumberOfVisitedCellsInAGridTest {

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(3, 4, 2),
            intArrayOf(2, 1, 3),
            intArrayOf(1, 4, 2)
        )
        assertEquals(3, Solution().minimumVisitedCells(grid))
    }

    @Test
    fun testSmallGrid() {
        val grid = arrayOf(
            intArrayOf(2, 1, 2),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(3, Solution().minimumVisitedCells(grid))
    }

    @Test
    fun testUnreachable() {
        val grid = arrayOf(
            intArrayOf(2, 1, 0),
            intArrayOf(1, 2, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(-1, Solution().minimumVisitedCells(grid))
    }

    @Test
    fun testSingleCell() {
        assertEquals(1, Solution().minimumVisitedCells(arrayOf(intArrayOf(0))))
    }

    @Test
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(1, 1, 1, 1))
        assertEquals(4, Solution().minimumVisitedCells(grid))
    }

    @Test
    fun testSingleColumn() {
        val grid = arrayOf(
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1)
        )
        assertEquals(3, Solution().minimumVisitedCells(grid))
    }

    @Test
    fun testTwoByTwo() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 1)
        )
        assertEquals(3, Solution().minimumVisitedCells(grid))
    }
}
