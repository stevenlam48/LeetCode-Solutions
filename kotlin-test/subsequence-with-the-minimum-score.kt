package subsequencewiththeminimumscore

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsequenceWithTheMinimumScoreTest {
    @Test
    fun testExample1() {
        assertEquals(1, Solution().minimumScore("abacaba", "bza"))
    }

    @Test
    fun testAlreadySubsequence() {
        assertEquals(0, Solution().minimumScore("abacaba", "abc"))
        assertEquals(0, Solution().minimumScore("abc", "abc"))
        assertEquals(0, Solution().minimumScore("aaaa", "aa"))
    }

    @Test
    fun testOneRemoval() {
        assertEquals(1, Solution().minimumScore("abc", "abd"))
        assertEquals(1, Solution().minimumScore("abcde", "aec"))
        assertEquals(1, Solution().minimumScore("ab", "ba"))
    }

    @Test
    fun testMultipleRemovals() {
        assertEquals(2, Solution().minimumScore("abc", "cba"))
    }

    @Test
    fun testNoMatch() {
        assertEquals(3, Solution().minimumScore("abc", "xyz"))
    }
}
