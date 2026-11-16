package maximumscorefromremovingsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreFromRemovingSubstringsTest {
    @Test
    fun exampleOne() {
        assertEquals(19, Solution().maximumGain("cdbcbbaaabab", 4, 5))
    }

    @Test
    fun exampleTwo() {
        assertEquals(20, Solution().maximumGain("aabbaaxybbaabb", 5, 4))
    }

    @Test
    fun higherValuePairIsRemovedFirst() {
        assertEquals(101, Solution().maximumGain("abba", 1, 100))
    }

    @Test
    fun noRemovablePair() {
        assertEquals(0, Solution().maximumGain("aaaa", 3, 7))
    }
}
