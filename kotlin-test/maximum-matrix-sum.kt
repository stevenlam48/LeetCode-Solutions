package maximummatrixsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumMatrixSumTest {
    private val solution = Solution()

    @Test
    fun `keeps all absolute values with an even negative count`() {
        assertEquals(4L, solution.maxMatrixSum(arrayOf(intArrayOf(1, -1), intArrayOf(-1, 1))))
    }

    @Test
    fun `subtracts twice the smallest absolute value for odd negative count`() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(-1, -2, -3), intArrayOf(1, 2, 3))
        assertEquals(16L, solution.maxMatrixSum(matrix))
    }

    @Test
    fun `handles one negative cell`() {
        assertEquals(-5L, solution.maxMatrixSum(arrayOf(intArrayOf(-5))))
    }

    @Test
    fun `uses zero as the smallest absolute value`() {
        assertEquals(2L, solution.maxMatrixSum(arrayOf(intArrayOf(0, -2))))
    }
}
