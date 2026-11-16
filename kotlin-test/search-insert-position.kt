package searchinsertposition

// Time:  O(logn)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchInsertPositionTest {
    private val nums = intArrayOf(1, 3, 5, 6)

    @Test
    fun targetExists() {
        assertEquals(2, Solution().searchInsert(nums, 5))
    }

    @Test
    fun insertInMiddle() {
        assertEquals(1, Solution().searchInsert(nums, 2))
    }

    @Test
    fun insertAtEnd() {
        assertEquals(4, Solution().searchInsert(nums, 7))
    }

    @Test
    fun insertAtBeginning() {
        assertEquals(0, Solution().searchInsert(nums, 0))
    }

    @Test
    fun emptyAndDuplicates() {
        assertEquals(0, Solution().searchInsert(intArrayOf(), 3))
        assertEquals(1, Solution().searchInsert(intArrayOf(1, 3, 3, 3, 5), 3))
    }
}
