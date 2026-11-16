package longestsubarraywithmaximumbitwiseand

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubarrayWithMaximumBitwiseAndTest {
    @Test
    fun twoMaximumValuesAreConsecutive() {
        assertEquals(2, Solution().longestSubarray(intArrayOf(1, 2, 3, 3, 2, 2)))
    }

    @Test
    fun uniqueMaximumHasLengthOne() {
        assertEquals(1, Solution().longestSubarray(intArrayOf(1, 4, 2)))
    }

    @Test
    fun allValuesAreMaximum() {
        assertEquals(4, Solution().longestSubarray(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    fun longestRunCanBeAtTheEnd() {
        assertEquals(3, Solution().longestSubarray(intArrayOf(7, 1, 7, 7, 7)))
    }
}
