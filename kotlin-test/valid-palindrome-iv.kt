package validpalindromeiv

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPalindromeIVTest {
    @Test
    fun alreadyPalindrome() {
        assertTrue(Solution().makePalindrome("abcba"))
    }

    @Test
    fun atMostTwoMismatchedPairs() {
        assertTrue(Solution().makePalindrome("abcdba"))
        assertTrue(Solution().makePalindrome("abcde"))
        assertTrue(Solution().makePalindrome("abca"))
    }

    @Test
    fun threeMismatchedPairs() {
        assertFalse(Solution().makePalindrome("abcdef"))
    }

    @Test
    fun shortStrings() {
        assertTrue(Solution().makePalindrome(""))
        assertTrue(Solution().makePalindrome("a"))
        assertTrue(Solution().makePalindrome("aa"))
    }
}
