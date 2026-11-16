package longestsubarrayof1safterdeletingoneelement

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubarrayOf1sAfterDeletingOneElementTest {
    @Test
    fun deletingTheOnlyZeroJoinsBothSides() {
        assertEquals(4, Solution().longestSubarray(intArrayOf(1, 1, 0, 1, 1)))
    }

    @Test
    fun oneElementMustStillBeDeletedWithoutZeroes() {
        assertEquals(2, Solution().longestSubarray(intArrayOf(1, 1, 1)))
    }

    @Test
    fun bestWindowMayContainOneZero() {
        assertEquals(3, Solution().longestSubarray(intArrayOf(0, 1, 1, 0, 1)))
    }

    @Test
    fun singleZeroBecomesEmpty() {
        assertEquals(0, Solution().longestSubarray(intArrayOf(0)))
    }
}
