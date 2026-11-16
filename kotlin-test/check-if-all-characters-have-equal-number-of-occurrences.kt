package checkifallcharactershaveequalnumberofoccurrences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAllCharactersHaveEqualNumberOfOccurrencesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.areOccurrencesEqual("abacbc"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.areOccurrencesEqual("aaabb"))
    }

    @Test
    fun testEvenCounts() {
        assertTrue(solution.areOccurrencesEqual("abcabc"))
    }

    @Test
    fun testSingleCharacter() {
        assertTrue(solution.areOccurrencesEqual("a"))
    }

    @Test
    fun testAllSame() {
        assertTrue(solution.areOccurrencesEqual("aaaa"))
    }
}
