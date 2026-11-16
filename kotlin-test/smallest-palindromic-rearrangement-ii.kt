package smallestpalindromicrearrangementii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestPalindromicRearrangementIITest {
    private val solution = Solution()

    @Test
    fun firstAndLastRanks() {
        assertEquals("abba", solution.smallestPalindrome("abba", 1))
        assertEquals("baab", solution.smallestPalindrome("abba", 2))
    }

    @Test
    fun rankBeyondNumberOfPalindromes() {
        assertEquals("", solution.smallestPalindrome("abba", 3))
        assertEquals("", solution.smallestPalindrome("aaaa", 2))
    }

    @Test
    fun distinctHalfCharacters() {
        assertEquals("bcaacb", solution.smallestPalindrome("abccba", 4))
        assertEquals("cbaabc", solution.smallestPalindrome("abccba", 6))
    }

    @Test
    fun oddLengthWithRepeatedHalfCharacters() {
        assertEquals("aabcbaa", solution.smallestPalindrome("aabcbaa", 1))
        assertEquals("abacaba", solution.smallestPalindrome("aabcbaa", 2))
        assertEquals("baacaab", solution.smallestPalindrome("aabcbaa", 3))
    }
}
