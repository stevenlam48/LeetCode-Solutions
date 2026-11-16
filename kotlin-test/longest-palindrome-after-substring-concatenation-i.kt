package longestpalindromeaftersubstringconcatenationi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromeAfterSubstringConcatenationITest {
    @Test
    fun fullConcatenation() {
        assertEquals(4, Solution().longestPalindrome("ab", "ba"))
    }

    @Test
    fun singleCharacters() {
        assertEquals(2, Solution().longestPalindrome("a", "a"))
    }

    @Test
    fun noCommonCharacter() {
        assertEquals(1, Solution().longestPalindrome("abc", "def"))
    }

    @Test
    fun differentSingleCharacters() {
        assertEquals(1, Solution().longestPalindrome("a", "b"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(4, Solution().longestPalindrome("aa", "aa"))
    }

    @Test
    fun oneSidedExtension() {
        assertEquals(3, Solution().longestPalindrome("ab", "a"))
    }
}
