package findtheoriginaltypedstringi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheOriginalTypedStringITest {
    private val solution = Solution()

    @Test
    fun repeatedGroupsOfferOneFewerPossibilityPerAdjacentRepeat() {
        assertEquals(5, solution.possibleStringCount("abbcccc"))
    }

    @Test
    fun allDistinctCharactersAllowOnlyOriginalWord() {
        assertEquals(1, solution.possibleStringCount("abcd"))
    }

    @Test
    fun everyRepeatedPositionCanBeReduced() {
        assertEquals(4, solution.possibleStringCount("aaaa"))
    }

    @Test
    fun multipleGroupsAccumulatePossibilities() {
        assertEquals(7, solution.possibleStringCount("aaabbbaaa"))
    }

    @Test
    fun alternatingCharactersAndSingleCharacterHaveNoReductions() {
        assertEquals(1, solution.possibleStringCount("ababab"))
        assertEquals(1, solution.possibleStringCount("z"))
    }

    @Test
    fun emptyWordMatchesDirectFormula() {
        assertEquals(0, solution.possibleStringCount(""))
    }
}
