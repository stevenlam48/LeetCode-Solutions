package sortthematrixdiagonally

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortTheMatrixDiagonallyTest {
    @Test
    fun standardExample() {
        val mat = arrayOf(
            intArrayOf(3, 3, 1, 1),
            intArrayOf(2, 2, 1, 1),
            intArrayOf(1, 1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 2, 1, 1),
            intArrayOf(1, 2, 3, 3)
        )
        assertMatrixEquals(expected, Solution().diagonalSort(mat))
        assertMatrixEquals(expected, mat)
    }

    @Test
    fun rectangularMatrix() {
        assertMatrixEquals(
            arrayOf(intArrayOf(2, 1, 1), intArrayOf(2, 3, 3)),
            Solution().diagonalSort(arrayOf(intArrayOf(3, 3, 1), intArrayOf(2, 2, 1)))
        )
    }

    @Test
    fun negativeValues() {
        assertMatrixEquals(
            arrayOf(intArrayOf(-2, 1), intArrayOf(-1, 0)),
            Solution().diagonalSort(arrayOf(intArrayOf(0, 1), intArrayOf(-1, -2)))
        )
    }

    @Test
    fun singleRowAndSingleElement() {
        assertMatrixEquals(
            arrayOf(intArrayOf(3, 2, 1)),
            Solution().diagonalSort(arrayOf(intArrayOf(3, 2, 1)))
        )
        assertMatrixEquals(
            arrayOf(intArrayOf(4)),
            Solution().diagonalSort(arrayOf(intArrayOf(4)))
        )
    }
}

private fun assertMatrixEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(expected.size, actual.size)
    for (i in expected.indices) {
        assertArrayEquals(expected[i], actual[i])
    }
}
