package findapeakelementii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindAPeakElementIITest {
    @Test
    fun example1() {
        val mat = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(3, 2)
        )
        assertArrayEquals(intArrayOf(0, 1), Solution().findPeakGrid(mat))
    }

    @Test
    fun example2() {
        val mat = arrayOf(
            intArrayOf(10, 20, 15),
            intArrayOf(21, 30, 14),
            intArrayOf(7, 16, 32)
        )
        assertArrayEquals(intArrayOf(2, 2), Solution().findPeakGrid(mat))
    }

    @Test
    fun singleRow() {
        val mat = arrayOf(intArrayOf(1, 2, 3))
        assertArrayEquals(intArrayOf(0, 2), Solution().findPeakGrid(mat))
    }

    @Test
    fun singleColumn() {
        val mat = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))
        assertArrayEquals(intArrayOf(2, 0), Solution().findPeakGrid(mat))
    }

    @Test
    fun singleCell() {
        assertArrayEquals(intArrayOf(0, 0), Solution().findPeakGrid(arrayOf(intArrayOf(7))))
    }

    @Test
    fun wideMatrix() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10)
        )
        assertArrayEquals(intArrayOf(1, 4), Solution().findPeakGrid(mat))
    }
}
