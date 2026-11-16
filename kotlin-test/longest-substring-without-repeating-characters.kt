package longestsubstringwithoutrepeatingcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    fun example() {
        assertEquals(3, Solution().lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun repeatedCharacter() {
        assertEquals(1, Solution().lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun substringSkipsRepeatedPrefix() {
        assertEquals(3, Solution().lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, Solution().lengthOfLongestSubstring(""))
    }

    @Test
    fun leftBoundaryOnlyMovesForward() {
        assertEquals(2, Solution().lengthOfLongestSubstring("abba"))
    }
}
