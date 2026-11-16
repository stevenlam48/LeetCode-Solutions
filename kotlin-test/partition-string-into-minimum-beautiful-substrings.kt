package partitionstringintominimumbeautifulsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionStringIntoMinimumBeautifulSubstringsTest {
    private val solution = Solution()

    @Test
    fun acceptsWholeStringWhenItIsPowerOfFive() {
        assertEquals(1, solution.minimumBeautifulSubstrings("101"))
    }

    @Test
    fun findsMinimumSplit() {
        assertEquals(2, solution.minimumBeautifulSubstrings("1011"))
    }

    @Test
    fun partitionsAllOnesIntoSingleBits() {
        assertEquals(3, solution.minimumBeautifulSubstrings("111"))
    }

    @Test
    fun rejectsLeadingZero() {
        assertEquals(-1, solution.minimumBeautifulSubstrings("0"))
    }
}
