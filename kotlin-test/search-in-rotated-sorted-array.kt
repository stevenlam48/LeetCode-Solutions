package searchinrotatedsortedarray

// Time:  O(logn)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchInRotatedSortedArrayTest {
    @Test
    fun findsTargetAfterRotation() {
        assertEquals(4, Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    }

    @Test
    fun missingTarget() {
        assertEquals(-1, Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    }

    @Test
    fun findsEveryElement() {
        val nums = intArrayOf(6, 7, 1, 2, 3, 4, 5)
        for (i in nums.indices) {
            assertEquals(i, Solution().search(nums, nums[i]))
        }
    }

    @Test
    fun unrotatedArray() {
        assertEquals(0, Solution().search(intArrayOf(1, 2, 3), 1))
        assertEquals(2, Solution().search(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun emptyAndSingleElement() {
        assertEquals(-1, Solution().search(intArrayOf(), 1))
        assertEquals(0, Solution().search(intArrayOf(1), 1))
        assertEquals(-1, Solution().search(intArrayOf(1), 0))
    }
}
