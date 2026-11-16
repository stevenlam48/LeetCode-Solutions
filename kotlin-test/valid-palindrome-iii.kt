package validpalindromeiii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPalindromeIIITest {
    @Test
    fun leetCodeExampleOne() {
        assertTrue(Solution().isValidPalindrome("abcdeca", 2))
    }

    @Test
    fun leetCodeExampleTwo() {
        assertTrue(Solution().isValidPalindrome("abbababa", 1))
    }

    @Test
    fun noRemovalAllowedOnNonPalindrome() {
        assertFalse(Solution().isValidPalindrome("abc", 0))
    }

    @Test
    fun alreadyPalindromeNeedsNoRemoval() {
        assertTrue(Solution().isValidPalindrome("abcba", 0))
        assertTrue(Solution().isValidPalindrome("a", 0))
    }

    @Test
    fun shortStringsWithBudget() {
        assertTrue(Solution().isValidPalindrome("ab", 1))
        assertFalse(Solution().isValidPalindrome("abcd", 1))
    }
}
