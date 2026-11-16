package longestpalindromeaftersubstringconcatenationii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromeAfterSubstringConcatenationIITest {
    @Test
    fun fullConcatenation() {
        assertEquals(4, Solution().longestPalindrome("ab", "ba"))
    }

    @Test
    fun noCommonCharacter() {
        assertEquals(1, Solution().longestPalindrome("abc", "def"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(4, Solution().longestPalindrome("aa", "aa"))
    }

    @Test
    fun singleCharacters() {
        assertEquals(2, Solution().longestPalindrome("a", "a"))
    }

    @Test
    fun oneSidedExtension() {
        assertEquals(3, Solution().longestPalindrome("ab", "a"))
    }

    @Test
    fun longerStrings() {
        assertEquals(10, Solution().longestPalindrome("abcba", "abcba"))
    }
}
