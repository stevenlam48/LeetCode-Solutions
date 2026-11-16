package vowelsofallsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VowelsOfAllSubstringsTest {
    private val solution = Solution()

    @Test
    fun countsStandardExamples() {
        assertEquals(6L, solution.countVowels("aba"))
        assertEquals(3L, solution.countVowels("abc"))
    }

    @Test
    fun countsEveryVowelContribution() {
        assertEquals(35L, solution.countVowels("aeiou"))
    }

    @Test
    fun handlesNoVowelsAndEmptyInput() {
        assertEquals(0L, solution.countVowels("bcd"))
        assertEquals(0L, solution.countVowels(""))
    }
}
