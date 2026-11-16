package validwordabbreviation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidWordAbbreviationTest {
    private val solution = Solution()

    @Test
    fun acceptsStandardAbbreviations() {
        assertTrue(solution.validWordAbbreviation("internationalization", "i12iz4n"))
        assertTrue(solution.validWordAbbreviation("substitution", "s10n"))
        assertTrue(solution.validWordAbbreviation("word", "4"))
    }

    @Test
    fun rejectsIncorrectMatchesAndLengths() {
        assertFalse(solution.validWordAbbreviation("apple", "a2e"))
        assertFalse(solution.validWordAbbreviation("word", "5"))
        assertFalse(solution.validWordAbbreviation("word", "w2"))
    }

    @Test
    fun rejectsLeadingZeroes() {
        assertFalse(solution.validWordAbbreviation("word", "w0rd"))
        assertFalse(solution.validWordAbbreviation("word", "04"))
    }
}
