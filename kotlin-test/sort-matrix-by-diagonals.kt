package sortmatrixbydiagonals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortMatrixByDiagonalsTest {
    @Test
    fun standardExample() {
        val grid = arrayOf(intArrayOf(1, 7, 3), intArrayOf(9, 8, 2), intArrayOf(4, 5, 6))
        val expected = arrayOf(intArrayOf(8, 2, 3), intArrayOf(9, 6, 7), intArrayOf(4, 5, 1))
        assertMatrixEquals(expected, Solution().sortMatrix(grid))
        assertMatrixEquals(expected, grid)
    }

    @Test
    fun rectangularMatrix() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertMatrixEquals(
            arrayOf(intArrayOf(5, 2, 3), intArrayOf(4, 1, 6)),
            Solution().sortMatrix(grid)
        )
    }

    @Test
    fun duplicateDiagonalValues() {
        val grid = arrayOf(intArrayOf(1, 1, 3), intArrayOf(2, 2, 1), intArrayOf(4, 2, 2))
        assertMatrixEquals(
            arrayOf(intArrayOf(2, 1, 3), intArrayOf(2, 2, 1), intArrayOf(4, 2, 1)),
            Solution().sortMatrix(grid)
        )
    }

    @Test
    fun singleElementMatrix() {
        assertMatrixEquals(
            arrayOf(intArrayOf(9)),
            Solution().sortMatrix(arrayOf(intArrayOf(9)))
        )
    }
}

private fun assertMatrixEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(expected.size, actual.size)
    for (i in expected.indices) {
        assertArrayEquals(expected[i], actual[i])
    }
}
