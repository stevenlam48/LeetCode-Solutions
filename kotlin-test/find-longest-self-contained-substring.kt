package findlongestselfcontainedsubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindLongestSelfContainedSubstringTest {
    @Test
    fun findsProperSubstringContainingEveryOccurrenceOfItsCharacters() {
        assertEquals(2, Solution().maxSubstringLength("abba"))
    }

    @Test
    fun includesNestedCharactersWhenTheirFullRangesAreIncluded() {
        assertEquals(3, Solution().maxSubstringLength("abcba"))
        assertEquals(4, Solution().maxSubstringLength("abacd"))
    }

    @Test
    fun excludesTheEntireString() {
        assertEquals(-1, Solution().maxSubstringLength("aaaa"))
        assertEquals(-1, Solution().maxSubstringLength("a"))
    }
}
