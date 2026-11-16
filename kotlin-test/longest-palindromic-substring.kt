package longestpalindromicsubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromicSubstringTest {
    @Test
    fun example1() {
        assertEquals("bab", Solution().longestPalindrome("babad"))
    }

    @Test
    fun example2() {
        assertEquals("bb", Solution().longestPalindrome("cbbd"))
    }

    @Test
    fun singleCharacter() {
        assertEquals("a", Solution().longestPalindrome("a"))
    }

    @Test
    fun twoDifferent() {
        assertEquals("a", Solution().longestPalindrome("ac"))
    }

    @Test
    fun allSame() {
        assertEquals("aaaa", Solution().longestPalindrome("aaaa"))
    }

    @Test
    fun wholeStringPalindrome() {
        assertEquals("racecar", Solution().longestPalindrome("racecar"))
    }
}
