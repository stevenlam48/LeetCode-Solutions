package longestpalindromicsubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromicSubsequenceTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().longestPalindromeSubseq("bbbab"))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().longestPalindromeSubseq("cbbd"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestPalindromeSubseq("a"))
    }

    @Test
    fun twoEqual() {
        assertEquals(2, Solution().longestPalindromeSubseq("aa"))
    }

    @Test
    fun twoDifferent() {
        assertEquals(1, Solution().longestPalindromeSubseq("ab"))
    }

    @Test
    fun alreadyPalindrome() {
        assertEquals(5, Solution().longestPalindromeSubseq("abcba"))
    }
}
