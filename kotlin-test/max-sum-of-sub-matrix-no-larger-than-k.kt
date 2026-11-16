package maxsumofsubmatrixnolargerthank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxSumOfSubMatrixNoLargerThanKTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        val matrix = arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, -2, 3))
        assertEquals(2, solution.maxSumSubmatrix(matrix, 2))
    }

    @Test
    fun computesSecondExample() {
        val matrix = arrayOf(intArrayOf(2, 2, -1))
        assertEquals(3, solution.maxSumSubmatrix(matrix, 3))
    }

    @Test
    fun handlesTallMatrixThroughTransposedTraversal() {
        val matrix = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(-1))
        assertEquals(3, solution.maxSumSubmatrix(matrix, 3))
    }

    @Test
    fun returnsLargestNegativeSumWithinLimit() {
        val matrix = arrayOf(intArrayOf(-5, -2), intArrayOf(-3, -4))
        assertEquals(-2, solution.maxSumSubmatrix(matrix, -1))
    }

    @Test
    fun supportsRectangularMatrices() {
        val matrix = arrayOf(
            intArrayOf(5, -4, -3, 4),
            intArrayOf(-3, -4, 4, 5),
            intArrayOf(5, 1, 5, -4)
        )
        assertEquals(8, solution.maxSumSubmatrix(matrix, 8))
    }

    @Test
    fun handlesEmptyMatrix() {
        assertEquals(0, solution.maxSumSubmatrix(arrayOf(), 0))
    }
}
