package shift2dgrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Shift2dGridTest {
    @Test
    fun shiftsByOne() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        assertArrayEquals(
            arrayOf(intArrayOf(9, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8)),
            Solution().shiftGrid(grid, 1)
        )
    }

    @Test
    fun shiftsAcrossRows() {
        val grid = arrayOf(intArrayOf(3, 8, 1, 9), intArrayOf(19, 7, 2, 5), intArrayOf(4, 6, 11, 10), intArrayOf(12, 0, 21, 13))
        assertArrayEquals(
            arrayOf(intArrayOf(12, 0, 21, 13), intArrayOf(3, 8, 1, 9), intArrayOf(19, 7, 2, 5), intArrayOf(4, 6, 11, 10)),
            Solution().shiftGrid(grid, 4)
        )
    }

    @Test
    fun handlesFullRotation() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertArrayEquals(
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)),
            Solution().shiftGrid(grid, 6)
        )
    }

    @Test
    fun handlesSingleRowAndLargeShift() {
        val grid = arrayOf(intArrayOf(1, 2, 3, 4))
        assertArrayEquals(arrayOf(intArrayOf(3, 4, 1, 2)), Solution().shiftGrid(grid, 10))
    }
}
