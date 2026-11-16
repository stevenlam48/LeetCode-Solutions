package maximumnumberofnonoverlappingpalindromesubstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfNonOverlappingPalindromeSubstringsTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(2, solution.maxPalindromes("abaccdbbd", 3))
    }

    @Test
    fun noPalindromeOfRequiredLength() {
        assertEquals(0, solution.maxPalindromes("adbcda", 2))
    }

    @Test
    fun singleCharacterPalindromes() {
        assertEquals(3, solution.maxPalindromes("abc", 1))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(2, solution.maxPalindromes("aaaa", 2))
    }

    @Test
    fun wholeStringIsPalindrome() {
        assertEquals(1, solution.maxPalindromes("abba", 4))
    }
}
