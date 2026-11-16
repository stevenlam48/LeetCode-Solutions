package shortestandlexicographicallysmallestbeautifulstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestAndLexicographicallySmallestBeautifulStringTest {
    @Test
    fun selectsShortestWindow() {
        assertEquals("11001", Solution().shortestBeautifulSubstring("100011001", 3))
    }

    @Test
    fun breaksLengthTiesLexicographically() {
        assertEquals("1011", Solution().shortestBeautifulSubstring("11010001011", 3))
        assertEquals("101", Solution().shortestBeautifulSubstring("001010", 2))
    }

    @Test
    fun returnsEmptyWhenThereAreTooFewOnes() {
        assertEquals("", Solution().shortestBeautifulSubstring("000", 1))
        assertEquals("", Solution().shortestBeautifulSubstring("010", 2))
    }

    @Test
    fun trimsLeadingZeroes() {
        assertEquals("11", Solution().shortestBeautifulSubstring("001100", 2))
    }
}
