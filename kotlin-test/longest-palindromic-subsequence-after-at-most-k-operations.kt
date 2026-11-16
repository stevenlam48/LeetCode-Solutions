package longestpalindromicsubsequenceafteratmostkoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromicSubsequenceAfterAtMostKOperationsTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().longestPalindromicSubsequence("abced", 2))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().longestPalindromicSubsequence("aaazzz", 4))
    }

    @Test
    fun oneOperation() {
        assertEquals(2, Solution().longestPalindromicSubsequence("abc", 1))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestPalindromicSubsequence("a", 0))
    }

    @Test
    fun noOperations() {
        assertEquals(1, Solution().longestPalindromicSubsequence("ab", 0))
    }

    @Test
    fun oneOperationPair() {
        assertEquals(2, Solution().longestPalindromicSubsequence("ab", 1))
    }
}
