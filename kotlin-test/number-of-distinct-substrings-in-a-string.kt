package numberofdistinctsubstringsinastring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfDistinctSubstringsInAStringTest {
    private val solution = Solution()

    @Test
    fun countsAllSubstringsOfDistinctCharacters() {
        assertEquals(6, solution.countDistinct("abc"))
    }

    @Test
    fun deduplicatesRepeatedCharacterSubstrings() {
        assertEquals(3, solution.countDistinct("aaa"))
    }

    @Test
    fun deduplicatesRepeatedPatterns() {
        assertEquals(7, solution.countDistinct("abab"))
    }

    @Test
    fun returnsZeroForEmptyString() {
        assertEquals(0, solution.countDistinct(""))
    }
}
