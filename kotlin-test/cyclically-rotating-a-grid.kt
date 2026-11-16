package cyclicallyrotatingagrid

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CyclicallyRotatingAGridTest {
    private fun assertGrid(expected: Array<IntArray>, actual: Array<IntArray>) {
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example1() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(3, 4, 8, 12),
            intArrayOf(2, 11, 10, 16),
            intArrayOf(1, 7, 6, 15),
            intArrayOf(5, 9, 13, 14)
        )
        assertGrid(expected, Solution().rotateGrid(grid, 2))
    }

    @Test
    fun example2() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        val expected = arrayOf(
            intArrayOf(3, 4, 8, 12),
            intArrayOf(2, 6, 7, 11),
            intArrayOf(1, 5, 9, 10)
        )
        assertGrid(expected, Solution().rotateGrid(grid, 2))
    }

    @Test
    fun singleCell() {
        val grid = arrayOf(intArrayOf(1))
        assertGrid(arrayOf(intArrayOf(1)), Solution().rotateGrid(grid, 5))
    }

    @Test
    fun singleRowUnchanged() {
        val grid = arrayOf(intArrayOf(1, 2))
        assertGrid(arrayOf(intArrayOf(1, 2)), Solution().rotateGrid(grid, 1))
    }

    @Test
    fun fullTurnIsIdentity() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        assertGrid(expected, Solution().rotateGrid(grid, 10))
    }
}
