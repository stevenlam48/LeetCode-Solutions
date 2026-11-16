package makestringantipalindrome

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeStringAntiPalindromeTest {
    private fun assertAntiPalindrome(result: String) {
        for (i in result.indices) {
            assertNotEquals(result[i], result[result.length - 1 - i], "palindromic pair at $i")
        }
    }

    @Test
    fun testPossibleEven() {
        val result = Solution().makeAntiPalindrome("aabb")
        assertEquals("aabb", result)
        assertAntiPalindrome(result)
    }

    @Test
    fun testPossibleThreeAndThree() {
        val result = Solution().makeAntiPalindrome("aaabbb")
        assertEquals("aaabbb", result)
        assertAntiPalindrome(result)
    }

    @Test
    fun testNeedsSwap() {
        val result = Solution().makeAntiPalindrome("aabbcc")
        assertEquals("aabcbc", result)
        assertAntiPalindrome(result)
    }

    @Test
    fun testTooManyOfOneCharacter() {
        assertEquals("-1", Solution().makeAntiPalindrome("aaaabb"))
    }

    @Test
    fun testOddLengthImpossible() {
        assertEquals("-1", Solution().makeAntiPalindrome("aab"))
    }

    @Test
    fun testDistinctCharacters() {
        assertEquals("abc", Solution().makeAntiPalindrome("abc"))
    }
}
