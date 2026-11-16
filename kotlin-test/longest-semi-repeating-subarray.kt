package longestsemirepeatingsubarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSemiRepeatingSubarrayTest {
    @Test
    fun distinctValuesUseTheWholeArray() {
        assertEquals(4, Solution().longestSubarray(intArrayOf(1, 2, 3, 4), 0))
    }

    @Test
    fun noRepeatsCanBeKeptWhenKIsZero() {
        assertEquals(1, Solution().longestSubarray(intArrayOf(1, 1, 1, 1), 0))
    }

    @Test
    fun excessRepeatRemovesFromTheLeft() {
        assertEquals(4, Solution().longestSubarray(intArrayOf(1, 2, 1, 2, 3), 1))
    }

    @Test
    fun twoRepeatedValuesAreAllowed() {
        assertEquals(5, Solution().longestSubarray(intArrayOf(1, 1, 2, 2, 3, 3), 2))
    }
}
