package findthegridofregionaverage

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheGridOfRegionAverageTest {
    private fun assertGrid(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example1() {
        val image = arrayOf(
            intArrayOf(5, 6, 7, 8, 9),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(7, 8, 9, 10, 11),
            intArrayOf(8, 9, 10, 11, 12),
            intArrayOf(9, 10, 11, 12, 13)
        )
        val expected = arrayOf(
            intArrayOf(7, 7, 8, 8, 9),
            intArrayOf(7, 8, 8, 9, 9),
            intArrayOf(8, 8, 9, 9, 10),
            intArrayOf(8, 9, 9, 10, 10),
            intArrayOf(9, 9, 10, 10, 11)
        )
        assertGrid(expected, Solution().resultGrid(image, 1))
    }

    @Test
    fun example2() {
        val image = arrayOf(
            intArrayOf(5, 6, 7),
            intArrayOf(6, 7, 8),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(7, 7, 7),
            intArrayOf(7, 7, 7),
            intArrayOf(7, 7, 7)
        )
        assertGrid(expected, Solution().resultGrid(image, 1))
    }

    @Test
    fun uniformGrid() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertGrid(expected, Solution().resultGrid(image, 0))
    }

    @Test
    fun singleCell() {
        val image = arrayOf(intArrayOf(7))
        assertGrid(arrayOf(intArrayOf(7)), Solution().resultGrid(image, 5))
    }
}
