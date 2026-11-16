package searchinrotatedsortedarrayii

// Time:  O(logn) ~ O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SearchInRotatedSortedArrayIiTest {
    @Test
    fun exampleWithDuplicates() {
        val nums = intArrayOf(2, 5, 6, 0, 0, 1, 2)
        assertTrue(Solution().search(nums, 0))
        assertFalse(Solution().search(nums, 3))
    }

    @Test
    fun duplicateHeavyRotation() {
        assertTrue(Solution().search(intArrayOf(1, 0, 1, 1, 1), 0))
    }

    @Test
    fun allElementsEqual() {
        assertTrue(Solution().search(intArrayOf(1, 1, 1, 1), 1))
        assertFalse(Solution().search(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun emptyInput() {
        assertFalse(Solution().search(intArrayOf(), 1))
    }

    @Test
    fun negativeValues() {
        val nums = intArrayOf(0, 2, 2, 2, -3, -2)
        assertTrue(Solution().search(nums, -2))
        assertFalse(Solution().search(nums, -1))
    }
}
