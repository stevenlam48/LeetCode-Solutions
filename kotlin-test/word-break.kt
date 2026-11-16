package wordbreak

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordBreakTest {
    @Test
    fun examples() {
        assertTrue(Solution().wordBreak("leetcode", setOf("leet", "code")))
        assertTrue(Solution().wordBreak("applepenapple", setOf("apple", "pen")))
        assertFalse(Solution().wordBreak("catsandog", setOf("cats", "dog", "sand", "and", "cat")))
    }

    @Test
    fun emptyString() {
        assertTrue(Solution().wordBreak("", emptySet()))
    }

    @Test
    fun emptyDictionary() {
        assertFalse(Solution().wordBreak("a", emptySet()))
    }

    @Test
    fun reusesDictionaryWords() {
        assertTrue(Solution().wordBreak("aaaaaaa", setOf("aa", "aaa")))
    }
}
