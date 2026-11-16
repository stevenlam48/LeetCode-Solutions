package lexicographicallysmallestpalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestPalindromeTest {
    @Test
    fun example1() {
        assertEquals("efcfe", Solution().makeSmallestPalindrome("egcfe"))
    }

    @Test
    fun example2() {
        assertEquals("abba", Solution().makeSmallestPalindrome("abcd"))
    }

    @Test
    fun example3() {
        assertEquals("neven", Solution().makeSmallestPalindrome("seven"))
    }

    @Test
    fun singleCharacter() {
        assertEquals("a", Solution().makeSmallestPalindrome("a"))
    }
}
