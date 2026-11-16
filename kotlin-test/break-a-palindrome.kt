package breakapalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BreakAPalindromeTest {
    @Test
    fun example1() {
        assertEquals("aaccba", Solution().breakPalindrome("abccba"))
    }

    @Test
    fun singleCharacter() {
        assertEquals("", Solution().breakPalindrome("a"))
    }

    @Test
    fun twoSameCharacters() {
        assertEquals("ab", Solution().breakPalindrome("aa"))
    }

    @Test
    fun allA() {
        assertEquals("aabab", Solution().breakPalindrome("aabaa"))
    }

    @Test
    fun middleOnly() {
        assertEquals("abb", Solution().breakPalindrome("aba"))
    }
}
