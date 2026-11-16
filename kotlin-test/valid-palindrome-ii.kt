package validpalindromeii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPalindromeIITest {
    @Test
    fun alreadyPalindrome() {
        assertTrue(Solution().validPalindrome("aba"))
    }

    @Test
    fun oneDeletionMakesPalindrome() {
        assertTrue(Solution().validPalindrome("abca"))
        assertTrue(Solution().validPalindrome("deeee"))
        assertTrue(Solution().validPalindrome("cbbcc"))
    }

    @Test
    fun cannotBeFixedWithOneDeletion() {
        assertFalse(Solution().validPalindrome("abc"))
    }

    @Test
    fun singleCharacter() {
        assertTrue(Solution().validPalindrome("a"))
    }

    @Test
    fun emptyString() {
        assertTrue(Solution().validPalindrome(""))
    }
}
