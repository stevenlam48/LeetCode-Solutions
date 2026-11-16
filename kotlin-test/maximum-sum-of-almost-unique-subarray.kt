package maximumsumofalmostuniquesubarray
// Time:  O(n)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfAlmostUniqueSubarrayTest {
    @Test
    fun exampleOne() {
        val nums = intArrayOf(2, 6, 7, 3, 1, 7)
        assertEquals(18L, Solution().maxSum(nums, 3, 4))
    }

    @Test
    fun exampleTwo() {
        val nums = intArrayOf(5, 9, 9, 2, 4, 5, 4)
        assertEquals(23L, Solution().maxSum(nums, 1, 3))
    }

    @Test
    fun noWindowHasEnoughUniqueValues() {
        val nums = intArrayOf(1, 2, 1, 2, 1, 2, 1)
        assertEquals(0L, Solution().maxSum(nums, 3, 3))
    }

    @Test
    fun windowLongerThanInput() {
        val nums = intArrayOf(3, 3, 4)
        assertEquals(0L, Solution().maxSum(nums, 1, 4))
    }

    @Test
    fun negativeWindowsKeepInitialResult() {
        val nums = intArrayOf(-2, -1, -2, -3)
        assertEquals(0L, Solution().maxSum(nums, 2, 3))
    }
}
