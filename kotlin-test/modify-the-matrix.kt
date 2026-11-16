package modifythematrix

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ModifyTheMatrixTest {
    private val solution = Solution()

    @Test
    fun replacesMissingValuesWithColumnMaxima() {
        val matrix = arrayOf(intArrayOf(1, 2, -1), intArrayOf(4, -1, 6), intArrayOf(7, 8, 9))
        val expected = arrayOf(intArrayOf(1, 2, 9), intArrayOf(4, 8, 6), intArrayOf(7, 8, 9))
        assertTrue(expected.contentDeepEquals(solution.modifiedMatrix(matrix)))
    }

    @Test
    fun keepsMinusOneWhenEntireColumnIsMissing() {
        val matrix = arrayOf(intArrayOf(-1, 2), intArrayOf(-1, 3))
        val expected = arrayOf(intArrayOf(-1, 2), intArrayOf(-1, 3))
        assertTrue(expected.contentDeepEquals(solution.modifiedMatrix(matrix)))
    }

    @Test
    fun handlesSingleMissingCell() {
        val matrix = arrayOf(intArrayOf(-1))
        assertTrue(arrayOf(intArrayOf(-1)).contentDeepEquals(solution.modifiedMatrix(matrix)))
    }
}
