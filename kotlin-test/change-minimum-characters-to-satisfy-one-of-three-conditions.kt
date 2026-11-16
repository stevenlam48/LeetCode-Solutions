package changeminimumcharacterstosatisfyoneofthreeconditions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ChangeMinimumCharactersToSatisfyOneOfThreeConditionsTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(2, solution.minCharacters("aba", "caa"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, solution.minCharacters("dabadd", "cda"))
    }

    @Test
    fun singleDistinctLetters() {
        assertEquals(0, solution.minCharacters("a", "b"))
        assertEquals(0, solution.minCharacters("b", "a"))
    }

    @Test
    fun sameSingleLetterNeedsNoChanges() {
        assertEquals(0, solution.minCharacters("aaa", "aaaa"))
    }
}
