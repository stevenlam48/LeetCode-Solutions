package numberofmatchingsubsequences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfMatchingSubsequencesTest {
    @Test
    fun standardExample() {
        val solution = Solution()
        assertEquals(3, solution.numMatchingSubseq("abcde", listOf("a", "bb", "acd", "ace")))
    }

    @Test
    fun duplicateWords() {
        val solution = Solution()
        assertEquals(2, solution.numMatchingSubseq("a", listOf("a", "a", "aa")))
    }

    @Test
    fun repeatedCharacters() {
        val solution = Solution()
        assertEquals(3, solution.numMatchingSubseq("aaaa", listOf("aaaa", "aa", "a", "b")))
    }

    @Test
    fun emptySourceMatchesNothing() {
        val solution = Solution()
        assertEquals(0, solution.numMatchingSubseq("", listOf("a", "abc", "b")))
    }

    @Test
    fun wordsWithAbsentCharacters() {
        val solution = Solution()
        assertEquals(0, solution.numMatchingSubseq("abc", listOf("d", "ae", "acb")))
    }
}
