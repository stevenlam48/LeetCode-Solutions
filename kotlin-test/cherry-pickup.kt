package cherrypickup

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CherryPickupTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val grid = arrayOf(
            intArrayOf(0, 1, -1),
            intArrayOf(1, 0, -1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(5, solution.cherryPickup(grid))
    }

    @Test
    fun testImpossible() {
        val grid = arrayOf(
            intArrayOf(1, 1, -1),
            intArrayOf(1, -1, 1),
            intArrayOf(-1, 1, 1)
        )
        assertEquals(0, solution.cherryPickup(grid))
    }

    @Test
    fun testSingleCell() {
        assertEquals(0, solution.cherryPickup(arrayOf(intArrayOf(0))))
    }

    @Test
    fun testSingleCellWithCherry() {
        assertEquals(1, solution.cherryPickup(arrayOf(intArrayOf(1))))
    }

    @Test
    fun testTwoByTwo() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(4, solution.cherryPickup(grid))
    }

    @Test
    fun testZeroGrid() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(0, solution.cherryPickup(grid))
    }
}
