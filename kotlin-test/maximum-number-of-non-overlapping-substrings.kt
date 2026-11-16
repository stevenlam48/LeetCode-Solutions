package maximumnumberofnonoverlappingsubstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfNonOverlappingSubstringsTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(listOf("e", "f", "ccc"), solution.maxNumOfSubstrings("adefaddaccc"))
    }

    @Test
    fun greedySelectionOfIndependentIntervals() {
        assertEquals(listOf("bb", "cc", "d"), solution.maxNumOfSubstrings("abbaccd"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(listOf("a"), solution.maxNumOfSubstrings("a"))
    }

    @Test
    fun nestedIntervalsRequireWholeString() {
        assertEquals(listOf("abab"), solution.maxNumOfSubstrings("abab"))
    }
}
