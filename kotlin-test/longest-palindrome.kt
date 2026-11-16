package longestpalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromeTest {
    @Test
    fun example1() {
        assertEquals(7, Solution().longestPalindrome("abccccdd"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestPalindrome("a"))
    }

    @Test
    fun pair() {
        assertEquals(2, Solution().longestPalindrome("bb"))
    }

    @Test
    fun noPair() {
        assertEquals(1, Solution().longestPalindrome("ab"))
    }

    @Test
    fun caseSensitive() {
        assertEquals(1, Solution().longestPalindrome("Aa"))
    }

    @Test
    fun allSame() {
        assertEquals(3, Solution().longestPalindrome("ccc"))
    }
}
