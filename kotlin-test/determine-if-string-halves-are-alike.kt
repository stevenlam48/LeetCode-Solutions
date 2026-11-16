package determineifstringhalvesarealike

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineIfStringHalvesAreAlikeTest {
    private val solution = Solution()

    @Test
    fun mixedCaseVowelsMatch() {
        assertTrue(solution.halvesAreAlike("book"))
    }

    @Test
    fun differentVowelCountsDoNotMatch() {
        assertFalse(solution.halvesAreAlike("textbook"))
    }

    @Test
    fun uppercaseVowelsAreCounted() {
        assertTrue(solution.halvesAreAlike("AbCdEfGh"))
    }

    @Test
    fun equalZeroVowelCountsMatch() {
        assertTrue(solution.halvesAreAlike("xyzw"))
    }

    @Test
    fun singleVowelInSecondHalfDoesNotMatch() {
        assertFalse(solution.halvesAreAlike("ba"))
    }
}
