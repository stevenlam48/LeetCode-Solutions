package findthelengthofthelongestcommonprefix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLengthOfTheLongestCommonPrefixTest {
    @Test
    fun example() {
        assertEquals(3, Solution().longestCommonPrefix(intArrayOf(1, 10, 100), intArrayOf(1000)))
    }

    @Test
    fun noCommonPrefix() {
        assertEquals(0, Solution().longestCommonPrefix(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun multipleMatches() {
        assertEquals(2, Solution().longestCommonPrefix(intArrayOf(13, 27, 45), intArrayOf(135, 275, 455)))
    }

    @Test
    fun exactMatch() {
        assertEquals(5, Solution().longestCommonPrefix(intArrayOf(12345), intArrayOf(12345)))
    }

    @Test
    fun emptySecondArray() {
        assertEquals(0, Solution().longestCommonPrefix(intArrayOf(12, 34), intArrayOf()))
    }
}
