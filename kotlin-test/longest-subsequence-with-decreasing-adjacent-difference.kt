package longestsubsequencewithdecreasingadjacentdifference

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubsequenceWithDecreasingAdjacentDifferenceTest {
    @Test
    fun increasingDifferencesCannotUseAllElements() {
        assertEquals(2, Solution().longestSubsequence(intArrayOf(1, 3, 6)))
    }

    @Test
    fun absoluteDifferencesDecrease() {
        assertEquals(3, Solution().longestSubsequence(intArrayOf(3, 1, 2)))
    }

    @Test
    fun equalDifferencesAreAllowed() {
        assertEquals(3, Solution().longestSubsequence(intArrayOf(1, 1, 1)))
    }

    @Test
    fun wholeSequenceCanHaveDecreasingDifferences() {
        assertEquals(5, Solution().longestSubsequence(intArrayOf(6, 1, 4, 2, 3)))
    }
}
