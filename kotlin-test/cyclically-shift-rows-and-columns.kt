package cyclicallyshiftrowsandcolumns

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CyclicallyShiftRowsAndColumnsTest {
    private fun assertGrid(expected: Array<IntArray>, actual: Array<IntArray>) {
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun columnShiftDown() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val expected = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(1, 4)
        )
        assertGrid(expected, Solution().cyclicShift(2, grid, intArrayOf(0, 0), intArrayOf(1, 0)))
    }

    @Test
    fun rowShiftLeft() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(2, 3, 1),
            intArrayOf(5, 6, 4),
            intArrayOf(8, 9, 7)
        )
        assertGrid(expected, Solution().cyclicShift(3, grid, intArrayOf(1, 1, 1), intArrayOf(0, 0, 0)))
    }

    @Test
    fun bothShifts() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val expected = arrayOf(
            intArrayOf(4, 3),
            intArrayOf(2, 1)
        )
        assertGrid(expected, Solution().cyclicShift(2, grid, intArrayOf(1, 1), intArrayOf(1, 1)))
    }

    @Test
    fun noShift() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertGrid(expected, Solution().cyclicShift(3, grid, intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)))
    }

    @Test
    fun singleCell() {
        val grid = arrayOf(intArrayOf(5))
        assertGrid(arrayOf(intArrayOf(5)), Solution().cyclicShift(1, grid, intArrayOf(0), intArrayOf(0)))
    }
}
