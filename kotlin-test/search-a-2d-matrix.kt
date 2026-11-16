package searcha2dmatrix

// Time:  O(logm + logn)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SearchA2dMatrixTest {
    private val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    @Test
    fun findsExistingValue() {
        assertTrue(Solution().searchMatrix(matrix, 3))
        assertTrue(Solution().searchMatrix(matrix, 60))
    }

    @Test
    fun rejectsMissingValue() {
        assertFalse(Solution().searchMatrix(matrix, 13))
    }

    @Test
    fun outsideValueRange() {
        assertFalse(Solution().searchMatrix(matrix, 0))
        assertFalse(Solution().searchMatrix(matrix, 61))
    }

    @Test
    fun emptyMatrix() {
        assertFalse(Solution().searchMatrix(emptyArray(), 1))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().searchMatrix(arrayOf(intArrayOf(1)), 1))
        assertFalse(Solution().searchMatrix(arrayOf(intArrayOf(1)), 2))
    }
}
