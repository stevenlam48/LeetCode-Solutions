package lastsubstringinlexicographicalorder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LastSubstringInLexicographicalOrderTest {
    private val solution = Solution()

    @Test
    fun repeatedPrefixExample() {
        assertEquals("bab", solution.lastSubstring("abab"))
    }

    @Test
    fun mixedCharactersExample() {
        assertEquals("tcode", solution.lastSubstring("leetcode"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals("aaaa", solution.lastSubstring("aaaa"))
    }

    @Test
    fun repeatedCandidateSuffixes() {
        assertEquals("zabcza", solution.lastSubstring("abczabcza"))
    }

    @Test
    fun emptyAndSingleCharacterInputs() {
        assertEquals("", solution.lastSubstring(""))
        assertEquals("z", solution.lastSubstring("z"))
    }
}
