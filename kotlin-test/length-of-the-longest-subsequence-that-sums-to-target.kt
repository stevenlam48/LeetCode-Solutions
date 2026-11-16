package lengthofthelongestsubsequencethatsumstotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfTheLongestSubsequenceThatSumsToTargetTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().lengthOfLongestSubsequence(intArrayOf(1, 2, 3, 4, 5), 9))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().lengthOfLongestSubsequence(intArrayOf(1, 2, 3, 4, 5), 7))
    }

    @Test
    fun singleElementReachable() {
        assertEquals(1, Solution().lengthOfLongestSubsequence(intArrayOf(5), 5))
    }

    @Test
    fun unreachableTarget() {
        assertEquals(-1, Solution().lengthOfLongestSubsequence(intArrayOf(5), 3))
    }

    @Test
    fun duplicateValues() {
        assertEquals(2, Solution().lengthOfLongestSubsequence(intArrayOf(1, 1, 5, 4, 5), 9))
    }

    @Test
    fun zeroTarget() {
        assertEquals(0, Solution().lengthOfLongestSubsequence(intArrayOf(1, 2), 0))
    }
}
