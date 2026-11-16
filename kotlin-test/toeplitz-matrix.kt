package toeplitzmatrix

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ToeplitzMatrixTest {
    private val solution = Solution()

    @Test
    fun standardToeplitzMatrix() {
        val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 1, 2, 3), intArrayOf(9, 5, 1, 2))
        assertTrue(solution.isToeplitzMatrix(matrix))
    }

    @Test
    fun diagonalMismatch() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(2, 2))
        assertFalse(solution.isToeplitzMatrix(matrix))
    }

    @Test
    fun singleRow() {
        assertTrue(solution.isToeplitzMatrix(arrayOf(intArrayOf(1, 4, 7))))
    }

    @Test
    fun singleColumn() {
        assertTrue(solution.isToeplitzMatrix(arrayOf(intArrayOf(8), intArrayOf(3), intArrayOf(5))))
    }
}
