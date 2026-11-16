package maximumstrictlyincreasingcellsinamatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumStrictlyIncreasingCellsInAMatrixTest {
    @Test
    fun example1() {
        val mat = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(3, 4)
        )
        assertEquals(2, Solution().maxIncreasingCells(mat))
    }

    @Test
    fun allEqual() {
        val mat = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(1, Solution().maxIncreasingCells(mat))
    }

    @Test
    fun sortedGrid() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(5, Solution().maxIncreasingCells(mat))
    }

    @Test
    fun singleCell() {
        assertEquals(1, Solution().maxIncreasingCells(arrayOf(intArrayOf(1))))
    }

    @Test
    fun singleRow() {
        assertEquals(3, Solution().maxIncreasingCells(arrayOf(intArrayOf(1, 2, 3))))
    }
}
