package validpalindrome

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPalindromeTest {
    @Test
    fun leetCodePalindromeExample() {
        assertTrue(Solution().isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun leetCodeNonPalindromeExample() {
        assertFalse(Solution().isPalindrome("race a car"))
    }

    @Test
    fun onlyNonAlphanumericCharacters() {
        assertTrue(Solution().isPalindrome(" "))
        assertTrue(Solution().isPalindrome(".,;"))
    }

    @Test
    fun emptyString() {
        assertTrue(Solution().isPalindrome(""))
    }

    @Test
    fun digitsAreCompared() {
        assertFalse(Solution().isPalindrome("0P"))
        assertTrue(Solution().isPalindrome("a1b1a"))
    }

    @Test
    fun underscoresAreIgnored() {
        assertTrue(Solution().isPalindrome("ab_a"))
    }
}
