package largest1borderedsquare

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Largest1BorderedSquareTest {
    @Test
    fun hollowSquare() {
        val grid = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
        assertEquals(9, Solution().largest1BorderedSquare(grid))
    }

    @Test
    fun singleCellBorder() {
        assertEquals(1, Solution().largest1BorderedSquare(arrayOf(intArrayOf(1, 1, 0, 0))))
    }

    @Test
    fun noBorder() {
        assertEquals(0, Solution().largest1BorderedSquare(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun filledRectangularGrid() {
        val grid = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        assertEquals(4, Solution().largest1BorderedSquare(grid))
    }
}
