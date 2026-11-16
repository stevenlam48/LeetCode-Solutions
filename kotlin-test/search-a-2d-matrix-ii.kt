package searcha2dmatrixii

// Time:  O(m + n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SearchA2dMatrixIiTest {
    private val matrix = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(3, 6, 9, 16, 22),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30)
    )

    @Test
    fun findsExistingValue() {
        assertTrue(Solution().searchMatrix(matrix, 5))
        assertTrue(Solution().searchMatrix(matrix, 18))
    }

    @Test
    fun rejectsMissingValue() {
        assertFalse(Solution().searchMatrix(matrix, 20))
    }

    @Test
    fun emptyDimensions() {
        assertFalse(Solution().searchMatrix(emptyArray(), 1))
        assertFalse(Solution().searchMatrix(arrayOf(intArrayOf()), 1))
    }

    @Test
    fun negativeValues() {
        val grid = arrayOf(intArrayOf(-5, -2, 0), intArrayOf(-3, 1, 4))
        assertTrue(Solution().searchMatrix(grid, -3))
        assertFalse(Solution().searchMatrix(grid, -4))
    }
}
