package shortestpalindrome

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPalindromeTest {
    @Test
    fun buildsPalindromeFromPartialPalindrome() {
        assertEquals("aaacecaaa", Solution().shortestPalindrome("aacecaaa"))
    }

    @Test
    fun prependsReverseWhenNoPalindromicPrefix() {
        assertEquals("dcbabcd", Solution().shortestPalindrome("abcd"))
    }

    @Test
    fun handlesEmptyAndSingleCharacter() {
        assertEquals("", Solution().shortestPalindrome(""))
        assertEquals("a", Solution().shortestPalindrome("a"))
    }

    @Test
    fun leavesPalindromeUnchanged() {
        assertEquals("aba", Solution().shortestPalindrome("aba"))
        assertEquals("aa", Solution().shortestPalindrome("aa"))
    }

    @Test
    fun handlesTwoCharacterNonPalindrome() {
        assertEquals("bab", Solution().shortestPalindrome("ab"))
    }
}
