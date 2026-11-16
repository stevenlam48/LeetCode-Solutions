package smallestpalindromicrearrangementi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestPalindromicRearrangementITest {
    private val solution = Solution()

    @Test
    fun evenLength() {
        assertEquals("abba", solution.smallestPalindrome("abba"))
        assertEquals("abccba", solution.smallestPalindrome("cbacba"))
    }

    @Test
    fun oddLength() {
        assertEquals("aabcbaa", solution.smallestPalindrome("aabcaba"))
        assertEquals("abbba", solution.smallestPalindrome("babab"))
    }

    @Test
    fun identicalCharacters() {
        assertEquals("aaaaa", solution.smallestPalindrome("aaaaa"))
    }
}
