package maximumnumberofoccurrencesofasubstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfOccurrencesOfASubstringTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(2, solution.maxFreq("aababcaab", 2, 3, 4))
    }

    @Test
    fun repeatedSingleLetter() {
        assertEquals(2, solution.maxFreq("aaaa", 1, 3, 3))
    }

    @Test
    fun mostFrequentSubstringOccursThreeTimes() {
        assertEquals(3, solution.maxFreq("aabcabcab", 2, 2, 3))
    }

    @Test
    fun everyCandidateOccursOnce() {
        assertEquals(1, solution.maxFreq("aabbc", 2, 3, 3))
    }

    @Test
    fun noCandidateSatisfiesLetterLimit() {
        assertEquals(0, solution.maxFreq("ababab", 1, 2, 3))
    }

    @Test
    fun minimumSizeExceedsStringLength() {
        assertEquals(0, solution.maxFreq("abc", 2, 4, 5))
    }
}
