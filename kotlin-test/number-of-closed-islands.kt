package numberofclosedislands

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfClosedIslandsTest {
    private val solution = Solution()

    @Test
    fun `counts two islands surrounded by water`() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
        )
        assertEquals(2, solution.closedIsland(grid))
    }

    @Test
    fun `counts one connected closed island`() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 1, 1, 1, 0)
        )
        assertEquals(1, solution.closedIsland(grid))
    }

    @Test
    fun `excludes land touching the boundary`() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(0, solution.closedIsland(grid))
    }

    @Test
    fun `counts one enclosed single cell island`() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(1, solution.closedIsland(grid))
    }

    @Test
    fun `handles a boundary only grid`() {
        assertEquals(0, solution.closedIsland(arrayOf(intArrayOf(0))))
    }
}
