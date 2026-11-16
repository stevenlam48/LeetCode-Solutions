package cherrypickupii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CherryPickupIITest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val grid = arrayOf(
            intArrayOf(3, 1, 1),
            intArrayOf(2, 5, 1),
            intArrayOf(1, 5, 5),
            intArrayOf(2, 1, 1)
        )
        assertEquals(24, solution.cherryPickup(grid))
    }

    @Test
    fun testExampleTwo() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0, 0, 0, 1),
            intArrayOf(2, 0, 0, 0, 0, 3, 0),
            intArrayOf(2, 0, 9, 0, 0, 0, 0),
            intArrayOf(0, 3, 0, 5, 4, 0, 0),
            intArrayOf(1, 0, 2, 3, 0, 0, 6)
        )
        assertEquals(28, solution.cherryPickup(grid))
    }

    @Test
    fun testTwoByTwo() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(10, solution.cherryPickup(grid))
    }

    @Test
    fun testAllOnesTwoByThree() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(4, solution.cherryPickup(grid))
    }

    @Test
    fun testTwoColumnsThreeRows() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )
        assertEquals(21, solution.cherryPickup(grid))
    }
}
