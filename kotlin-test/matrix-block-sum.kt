package matrixblocksum

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MatrixBlockSumTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        val mat = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val expected = arrayOf(intArrayOf(12, 21, 16), intArrayOf(27, 45, 33), intArrayOf(24, 39, 28))
        assertMatrixEquals(expected, solution.matrixBlockSum(mat, 1))
    }

    @Test
    fun computesSecondExample() {
        val mat = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val expected = arrayOf(intArrayOf(45, 45, 45), intArrayOf(45, 45, 45), intArrayOf(45, 45, 45))
        assertMatrixEquals(expected, solution.matrixBlockSum(mat, 2))
    }

    @Test
    fun zeroRadiusReturnsOriginalMatrix() {
        val mat = arrayOf(intArrayOf(-1, 2), intArrayOf(3, -4))
        val expected = arrayOf(intArrayOf(-1, 2), intArrayOf(3, -4))
        assertMatrixEquals(expected, solution.matrixBlockSum(mat, 0))
    }

    @Test
    fun handlesSingleCell() {
        assertMatrixEquals(arrayOf(intArrayOf(7)), solution.matrixBlockSum(arrayOf(intArrayOf(7)), 3))
    }

    private fun assertMatrixEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertArrayEquals(expected, actual)
    }
}
