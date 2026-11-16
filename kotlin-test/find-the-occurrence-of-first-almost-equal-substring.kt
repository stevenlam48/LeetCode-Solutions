package findtheoccurrenceoffirstalmostequalsubstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheOccurrenceOfFirstAlmostEqualSubstringTest {
    private val solution = Solution()

    @Test
    fun oneInteriorMismatchIsAccepted() {
        assertEquals(1, solution.minStartingIndex("abcdefg", "bcdffg"))
    }

    @Test
    fun exactMatchReturnsItsStartingIndex() {
        assertEquals(2, solution.minStartingIndex("abcdef", "cdef"))
    }

    @Test
    fun twoMismatchesAreRejected() {
        assertEquals(-1, solution.minStartingIndex("aaaa", "bb"))
    }

    @Test
    fun earliestAlmostEqualSubstringWins() {
        assertEquals(0, solution.minStartingIndex("ababa", "aaa"))
    }

    @Test
    fun singleCharacterMayDiffer() {
        assertEquals(0, solution.minStartingIndex("x", "y"))
    }

    @Test
    fun patternLongerThanTextHasNoOccurrence() {
        assertEquals(-1, solution.minStartingIndex("abc", "abcd"))
    }
}
