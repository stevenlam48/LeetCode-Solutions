package imagesmoother

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ImageSmootherTest {
    private fun assertMatrix(expected: Array<IntArray>, actual: Array<IntArray>) {
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example1() {
        val m = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertMatrix(expected, Solution().imageSmoother(m))
    }

    @Test
    fun example2() {
        val m = arrayOf(
            intArrayOf(100, 200, 100),
            intArrayOf(200, 50, 200),
            intArrayOf(100, 200, 100)
        )
        val expected = arrayOf(
            intArrayOf(137, 141, 137),
            intArrayOf(141, 138, 141),
            intArrayOf(137, 141, 137)
        )
        assertMatrix(expected, Solution().imageSmoother(m))
    }

    @Test
    fun singleCell() {
        assertMatrix(arrayOf(intArrayOf(5)), Solution().imageSmoother(arrayOf(intArrayOf(5))))
    }

    @Test
    fun singleRow() {
        val expected = arrayOf(intArrayOf(1, 2, 2))
        assertMatrix(expected, Solution().imageSmoother(arrayOf(intArrayOf(1, 2, 3))))
    }
}
