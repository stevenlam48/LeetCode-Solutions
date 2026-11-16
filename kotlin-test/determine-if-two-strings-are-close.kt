package determineiftwostringsareclose

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineIfTwoStringsAreCloseTest {
    private val solution = Solution()

    @Test
    fun swappingOccurrencesMakesStringsClose() {
        assertTrue(solution.closeStrings("abc", "bca"))
    }

    @Test
    fun differentCharacterSetsAreNotClose() {
        assertFalse(solution.closeStrings("a", "aa"))
    }

    @Test
    fun transformingRecurringFrequenciesMakesStringsClose() {
        assertTrue(solution.closeStrings("cabbba", "abbccc"))
    }

    @Test
    fun unequalFrequencyProfilesAreNotClose() {
        assertFalse(solution.closeStrings("aaabbc", "aabbcc"))
    }

    @Test
    fun sameSingleCharacterIsClose() {
        assertTrue(solution.closeStrings("z", "z"))
    }
}
