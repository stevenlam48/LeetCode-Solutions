package shortestcommonsupersequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestCommonSupersequenceTest {
    @Test
    fun mergesCommonSubsequence() {
        assertEquals("cabac", Solution().shortestCommonSupersequence("abac", "cab"))
    }

    @Test
    fun handlesIdenticalStrings() {
        assertEquals("aaaaaaaa", Solution().shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals("abc", Solution().shortestCommonSupersequence("", "abc"))
        assertEquals("abc", Solution().shortestCommonSupersequence("abc", ""))
        assertEquals("", Solution().shortestCommonSupersequence("", ""))
    }

    @Test
    fun handlesDisjointSingleCharacters() {
        assertEquals("ab", Solution().shortestCommonSupersequence("a", "b"))
    }
}
