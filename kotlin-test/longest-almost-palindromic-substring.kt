package longestalmostpalindromicsubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestAlmostPalindromicSubstringTest {
    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().almostPalindromic("a"))
    }

    @Test
    fun twoCharacters() {
        assertEquals(2, Solution().almostPalindromic("ab"))
    }

    @Test
    fun noLongSubstring() {
        assertEquals(2, Solution().almostPalindromic("abc"))
        assertEquals(2, Solution().almostPalindromic("abcdef"))
    }

    @Test
    fun removeOneInnerCharacter() {
        assertEquals(4, Solution().almostPalindromic("abca"))
        assertEquals(3, Solution().almostPalindromic("aab"))
    }

    @Test
    fun doubleCharacterWithUnmatchedPrefix() {
        assertEquals(3, Solution().almostPalindromic("abb"))
    }

    @Test
    fun alreadyPalindrome() {
        assertEquals(4, Solution().almostPalindromic("abba"))
        assertEquals(5, Solution().almostPalindromic("abcba"))
        assertEquals(3, Solution().almostPalindromic("aabb"))
    }
}
