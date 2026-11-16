package longestpalindromebyconcatenatingtwoletterwords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromeByConcatenatingTwoLetterWordsTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().longestPalindrome(arrayOf("lc", "cl", "gg")))
    }

    @Test
    fun example2() {
        assertEquals(8, Solution().longestPalindrome(arrayOf("ab", "ty", "yt", "lc", "cl", "ab")))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().longestPalindrome(arrayOf("cc", "ll", "xx")))
    }

    @Test
    fun singleWord() {
        assertEquals(2, Solution().longestPalindrome(arrayOf("aa")))
        assertEquals(0, Solution().longestPalindrome(arrayOf("ab")))
    }

    @Test
    fun mirroredPair() {
        assertEquals(4, Solution().longestPalindrome(arrayOf("ab", "ba")))
    }

    @Test
    fun duplicateSelfMirror() {
        assertEquals(4, Solution().longestPalindrome(arrayOf("aa", "aa")))
    }
}
