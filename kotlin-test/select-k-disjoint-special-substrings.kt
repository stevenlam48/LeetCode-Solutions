package selectkdisjointspecialsubstrings

// Time:  O(n + 26^3)
// Space: O(26)

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SelectKDisjointSpecialSubstringsTest {
    @Test
    fun firstExample() {
        assertTrue(Solution().maxSubstringLength("abcdbaefab", 2))
    }

    @Test
    fun noSpecialSubstring() {
        assertFalse(Solution().maxSubstringLength("cdddcd", 1))
    }

    @Test
    fun insufficientSpecialSubstrings() {
        assertFalse(Solution().maxSubstringLength("aba", 2))
    }

    @Test
    fun zeroRequiredSubstrings() {
        assertTrue(Solution().maxSubstringLength("a", 0))
    }

    @Test
    fun everyIntervalCoversWholeString() {
        assertFalse(Solution().maxSubstringLength("abab", 1))
        assertFalse(Solution().maxSubstringLength("aa", 1))
    }

    @Test
    fun overlappingAlternatives() {
        assertTrue(Solution().maxSubstringLength("abca", 2))
        assertFalse(Solution().maxSubstringLength("abca", 3))
    }
}
