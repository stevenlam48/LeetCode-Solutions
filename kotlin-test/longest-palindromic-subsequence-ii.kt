package longestpalindromicsubsequenceii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromicSubsequenceIiTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().longestPalindromeSubseq("bbabab"))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().longestPalindromeSubseq("dcbccacdb"))
    }

    @Test
    fun twoEqual() {
        assertEquals(2, Solution().longestPalindromeSubseq("aa"))
    }

    @Test
    fun twoDifferent() {
        assertEquals(0, Solution().longestPalindromeSubseq("ab"))
    }

    @Test
    fun threeDifferent() {
        assertEquals(0, Solution().longestPalindromeSubseq("abc"))
    }

    @Test
    fun outerPair() {
        assertEquals(2, Solution().longestPalindromeSubseq("aba"))
    }
}
