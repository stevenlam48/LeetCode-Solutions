package findthelongestbalancedsubstringofabinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLongestBalancedSubstringOfABinaryStringTest {
    @Test
    fun example() {
        assertEquals(6, Solution().findTheLongestBalancedSubstring("01000111"))
    }

    @Test
    fun shorterBalancedSubstring() {
        assertEquals(4, Solution().findTheLongestBalancedSubstring("00111"))
    }

    @Test
    fun noBalancedSubstring() {
        assertEquals(0, Solution().findTheLongestBalancedSubstring("111"))
    }

    @Test
    fun singlePair() {
        assertEquals(2, Solution().findTheLongestBalancedSubstring("01"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, Solution().findTheLongestBalancedSubstring(""))
    }
}
