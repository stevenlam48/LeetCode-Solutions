package p01matrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class P01matrixTest {
    @Test
    fun example1() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
        val actual = Solution().updateMatrix(matrix)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example2() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 2, 1)
        )
        val actual = Solution().updateMatrix(matrix)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun singleZero() {
        val actual = Solution().updateMatrix(arrayOf(intArrayOf(0)))
        assertArrayEquals(intArrayOf(0), actual[0])
    }

    @Test
    fun singleOne() {
        val actual = Solution().updateMatrix(arrayOf(intArrayOf(1)))
        assertArrayEquals(intArrayOf(Int.MAX_VALUE), actual[0])
    }

    @Test
    fun farCorner() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(0, 1, 2, 3),
            intArrayOf(1, 2, 3, 4),
            intArrayOf(2, 3, 4, 5)
        )
        val actual = Solution().updateMatrix(matrix)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }
}
