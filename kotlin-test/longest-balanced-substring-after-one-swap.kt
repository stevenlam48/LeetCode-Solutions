package longestbalancedsubstringafteroneswap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubstringAfterOneSwapTest {
    @Test
    fun twoCharacters() {
        assertEquals(2, Solution().longestBalanced("10"))
    }

    @Test
    fun alreadyBalanced() {
        assertEquals(4, Solution().longestBalanced("1100"))
        assertEquals(8, Solution().longestBalanced("11110000"))
    }

    @Test
    fun noOnesOrNoZeros() {
        assertEquals(0, Solution().longestBalanced("0000"))
        assertEquals(0, Solution().longestBalanced("1111"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, Solution().longestBalanced("0"))
        assertEquals(0, Solution().longestBalanced("1"))
    }

    @Test
    fun shorterBalancedSubstring() {
        assertEquals(2, Solution().longestBalanced("100"))
        assertEquals(4, Solution().longestBalanced("11100"))
    }

    @Test
    fun alternatingCharacters() {
        assertEquals(4, Solution().longestBalanced("0101"))
    }
}
