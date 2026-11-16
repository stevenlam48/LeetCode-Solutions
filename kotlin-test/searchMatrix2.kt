package searchMatrix2

// Time Complexity: O(log(mn))
// Space Complexity: O(1)

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SearchMatrix2Test {
    private val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    @Test
    fun findsExistingValues() {
        assertTrue(Solution().searchMatrix(matrix, 3))
        assertTrue(Solution().searchMatrix(matrix, 23))
    }

    @Test
    fun rejectsMissingValue() {
        assertFalse(Solution().searchMatrix(matrix, 13))
    }

    @Test
    fun outsideValueRange() {
        assertFalse(Solution().searchMatrix(matrix, 0))
        assertFalse(Solution().searchMatrix(matrix, 100))
    }

    @Test
    fun emptyMatrix() {
        assertFalse(Solution().searchMatrix(emptyArray(), 1))
    }

    @Test
    fun oneRow() {
        val row = arrayOf(intArrayOf(-3, 0, 2, 8))
        assertTrue(Solution().searchMatrix(row, -3))
        assertFalse(Solution().searchMatrix(row, 1))
    }
}
