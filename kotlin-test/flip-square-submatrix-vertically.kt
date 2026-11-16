package flipsquaresubmatrixvertically

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FlipSquareSubmatrixVerticallyTest {
    @Test
    fun standardExample() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(13, 14, 15, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(5, 6, 7, 16)
        )
        assertArrayEquals(expected, Solution().reverseSubmatrix(grid, 1, 0, 3))
    }

    @Test
    fun singleCellSubmatrix() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val expected = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertArrayEquals(expected, Solution().reverseSubmatrix(grid, 1, 1, 1))
    }

    @Test
    fun offsetEvenSizedSubmatrix() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(1, 5, 6),
            intArrayOf(4, 2, 3),
            intArrayOf(7, 8, 9)
        )
        assertArrayEquals(expected, Solution().reverseSubmatrix(grid, 0, 1, 2))
    }
}
