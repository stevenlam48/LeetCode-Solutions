package wordpattern

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordPatternTest {
    @Test
    fun examples() {
        assertTrue(Solution().wordPattern("abba", "dog cat cat dog"))
        assertFalse(Solution().wordPattern("abba", "dog cat cat fish"))
        assertFalse(Solution().wordPattern("aaaa", "dog cat cat dog"))
        assertFalse(Solution().wordPattern("abba", "dog dog dog dog"))
    }

    @Test
    fun differentLengths() {
        assertFalse(Solution().wordPattern("ab", "dog"))
        assertFalse(Solution().wordPattern("a", "dog cat"))
    }

    @Test
    fun emptyPatternAndString() {
        assertTrue(Solution().wordPattern("", ""))
        assertFalse(Solution().wordPattern("a", ""))
    }

    @Test
    fun repeatedWordsWithDistinctPatterns() {
        assertFalse(Solution().wordPattern("abc", "dog dog dog"))
        assertTrue(Solution().wordPattern("aaa", "dog dog dog"))
    }
}
