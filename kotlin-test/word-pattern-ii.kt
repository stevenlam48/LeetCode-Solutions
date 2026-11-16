package wordpatternii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordPatternIiTest {
    @Test
    fun examples() {
        assertTrue(Solution().wordPatternMatch("abab", "redblueredblue"))
        assertTrue(Solution().wordPatternMatch("aaaa", "asdasdasdasd"))
        assertFalse(Solution().wordPatternMatch("aabb", "xyzabcxzyabc"))
    }

    @Test
    fun emptyInputs() {
        assertTrue(Solution().wordPatternMatch("", ""))
        assertFalse(Solution().wordPatternMatch("", "a"))
        assertFalse(Solution().wordPatternMatch("a", ""))
    }

    @Test
    fun mappingMustBeBijective() {
        assertFalse(Solution().wordPatternMatch("ab", "aa"))
        assertTrue(Solution().wordPatternMatch("ab", "ab"))
    }

    @Test
    fun requiresBacktracking() {
        assertFalse(Solution().wordPatternMatch("abcb", "xyzabcxyzabc"))
        assertFalse(Solution().wordPatternMatch("abc", "aaaa"))
    }
}
