package countingwordswithagivenprefix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountingWordsWithAGivenPrefixTest {
    @Test
    fun `counts words with the prefix`() {
        val words = listOf("pay", "attention", "practice", "attend")
        assertEquals(2, Solution().prefixCount(words, "at"))
    }

    @Test
    fun `returns zero when no word has the prefix`() {
        val words = listOf("leetcode", "win", "loops", "success")
        assertEquals(0, Solution().prefixCount(words, "code"))
    }

    @Test
    fun `handles empty input and exact matches`() {
        assertEquals(0, Solution().prefixCount(emptyList(), "a"))
        assertEquals(2, Solution().prefixCount(listOf("a", "ab", "b"), "a"))
        assertEquals(3, Solution().prefixCount(listOf("a", "ab", "b"), ""))
    }
}
