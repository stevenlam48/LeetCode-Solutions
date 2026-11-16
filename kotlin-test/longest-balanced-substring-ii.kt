package longestbalancedsubstringii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubstringIiTest {
    @Test
    fun threeDistinctCharacters() {
        assertEquals(6, Solution().longestBalanced("abcabc"))
        assertEquals(9, Solution().longestBalanced("aaabbbccc"))
    }

    @Test
    fun twoDistinctCharacters() {
        assertEquals(4, Solution().longestBalanced("abab"))
        assertEquals(6, Solution().longestBalanced("aaabbb"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestBalanced("a"))
        assertEquals(3, Solution().longestBalanced("aaa"))
    }

    @Test
    fun shorterBalancedSubstring() {
        assertEquals(3, Solution().longestBalanced("abca"))
        assertEquals(3, Solution().longestBalanced("abc"))
    }

    @Test
    fun singleCharacterTypesCombined() {
        assertEquals(4, Solution().longestBalanced("aabbc"))
    }
}
