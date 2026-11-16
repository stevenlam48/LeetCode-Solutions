package maximizepalindromelengthfromsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizePalindromeLengthFromSubsequencesTest {
    @Test
    fun firstExample() {
        assertEquals(5, Solution().longestPalindrome("cacb", "cbba"))
    }

    @Test
    fun secondExample() {
        assertEquals(3, Solution().longestPalindrome("ab", "ab"))
    }

    @Test
    fun noMatchingCharactersAcrossBoundary() {
        assertEquals(0, Solution().longestPalindrome("aa", "bb"))
    }

    @Test
    fun singleMatchingCharactersFormPair() {
        assertEquals(2, Solution().longestPalindrome("a", "a"))
    }

    @Test
    fun reversedWordsFormFullPalindrome() {
        assertEquals(10, Solution().longestPalindrome("abcde", "edcba"))
    }

    @Test
    fun emptyFirstWordCannotCrossBoundary() {
        assertEquals(0, Solution().longestPalindrome("", "a"))
    }
}
