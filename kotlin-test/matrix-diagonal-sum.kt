package matrixdiagonalsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MatrixDiagonalSumTest {
    private val solution = Solution()

    @Test
    fun sumsOddSizedExampleWithoutDoubleCountingCenter() {
        val mat = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        assertEquals(25, solution.diagonalSum(mat))
    }

    @Test
    fun sumsEvenSizedExample() {
        val mat = arrayOf(
            intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 1)
        )
        assertEquals(8, solution.diagonalSum(mat))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(5, solution.diagonalSum(arrayOf(intArrayOf(5))))
    }

    @Test
    fun handlesNegativeValues() {
        val mat = arrayOf(intArrayOf(-1, 4), intArrayOf(3, -2))
        assertEquals(4, solution.diagonalSum(mat))
    }

    @Test
    fun handlesEmptyMatrix() {
        assertEquals(0, solution.diagonalSum(arrayOf()))
    }
}
