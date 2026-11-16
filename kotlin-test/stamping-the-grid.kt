package stampingthegrid

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StampingTheGridTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0)
        )
        assertTrue(solution.possibleToStamp(grid, 4, 3))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 0, 1)
        )
        assertFalse(solution.possibleToStamp(grid, 2, 2))
    }

    @Test
    fun testExample3() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0)
        )
        assertFalse(solution.possibleToStamp(grid, 3, 4))
    }

    @Test
    fun testExample4() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0)
        )
        assertTrue(solution.possibleToStamp(grid, 2, 3))
    }

    @Test
    fun testAllOccupied() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertTrue(solution.possibleToStamp(grid, 2, 2))
    }

    @Test
    fun testSingleCellEmpty() {
        val grid = arrayOf(intArrayOf(0))
        assertTrue(solution.possibleToStamp(grid, 1, 1))
    }
}
