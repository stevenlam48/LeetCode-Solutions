package multisourcefloodfill

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MultiSourceFloodFillTest {
    private fun assertGrid(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun twoCorners() {
        val sources = arrayOf(intArrayOf(0, 0, 1), intArrayOf(2, 2, 2))
        val expected = arrayOf(
            intArrayOf(1, 1, 2),
            intArrayOf(1, 2, 2),
            intArrayOf(2, 2, 2)
        )
        assertGrid(expected, Solution().colorGrid(3, 3, sources))
    }

    @Test
    fun singleSource() {
        val sources = arrayOf(intArrayOf(0, 0, 5))
        val expected = arrayOf(
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5)
        )
        assertGrid(expected, Solution().colorGrid(2, 3, sources))
    }

    @Test
    fun singleCell() {
        val sources = arrayOf(intArrayOf(0, 0, 7))
        assertGrid(arrayOf(intArrayOf(7)), Solution().colorGrid(1, 1, sources))
    }

    @Test
    fun oneRowTie() {
        val sources = arrayOf(intArrayOf(0, 0, 1), intArrayOf(0, 2, 2))
        assertGrid(arrayOf(intArrayOf(1, 2, 2)), Solution().colorGrid(1, 3, sources))
    }

    @Test
    fun adjacentSources() {
        val sources = arrayOf(intArrayOf(0, 0, 3), intArrayOf(0, 1, 4))
        assertGrid(arrayOf(intArrayOf(3, 4)), Solution().colorGrid(1, 2, sources))
    }
}
