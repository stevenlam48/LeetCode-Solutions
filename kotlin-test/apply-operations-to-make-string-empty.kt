package applyoperationstomakestringempty

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyOperationsToMakeStringEmptyTest {
    private val solution = Solution()

    @Test
    fun allCharactersHaveMaximumFrequency() {
        assertEquals("abcd", solution.lastNonEmptyString("abcd"))
    }

    @Test
    fun onlyMostFrequentCharacterSurvives() {
        assertEquals("a", solution.lastNonEmptyString("abca"))
    }

    @Test
    fun simultaneousMaximumFrequenciesPreserveOriginalOrder() {
        assertEquals("ba", solution.lastNonEmptyString("aabcbbca"))
    }

    @Test
    fun emptyString() {
        assertEquals("", solution.lastNonEmptyString(""))
    }
}
