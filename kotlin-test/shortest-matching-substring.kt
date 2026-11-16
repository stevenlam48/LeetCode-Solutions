package shortestmatchingsubstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestMatchingSubstringTest {
    @Test
    fun findsShortestSubstringWithTwoSeparators() {
        assertEquals(8, Solution().shortestMatchingSubstring("abaacbaecebce", "ba*c*ce"))
    }

    @Test
    fun matchesPartsWithNoGap() {
        assertEquals(3, Solution().shortestMatchingSubstring("abcdef", "b**d"))
    }

    @Test
    fun handlesEmptyPatternParts() {
        assertEquals(0, Solution().shortestMatchingSubstring("abcdef", "**"))
        assertEquals(1, Solution().shortestMatchingSubstring("a", "*a*"))
        assertEquals(2, Solution().shortestMatchingSubstring("aaabbb", "a**b"))
    }

    @Test
    fun returnsMinusOneWhenNoMatchExists() {
        assertEquals(-1, Solution().shortestMatchingSubstring("abcdef", "x**y"))
        assertEquals(-1, Solution().shortestMatchingSubstring("abcdef", "c**a"))
    }

    @Test
    fun picksEarliestCompletingParts() {
        assertEquals(3, Solution().shortestMatchingSubstring("abcabc", "a**c"))
        assertEquals(3, Solution().shortestMatchingSubstring("aaaa", "a*a*a"))
    }
}
