package longestbalancedsubstringi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubstringITest {
    @Test
    fun twoDistinctCharacters() {
        assertEquals(4, Solution().longestBalanced("abab"))
    }

    @Test
    fun threeDistinctCharacters() {
        assertEquals(6, Solution().longestBalanced("abcabc"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestBalanced("a"))
        assertEquals(3, Solution().longestBalanced("aaa"))
    }

    @Test
    fun allDistinct() {
        assertEquals(4, Solution().longestBalanced("abcd"))
    }

    @Test
    fun shorterBalancedSubstring() {
        assertEquals(3, Solution().longestBalanced("abac"))
        assertEquals(4, Solution().longestBalanced("aabbc"))
    }
}
