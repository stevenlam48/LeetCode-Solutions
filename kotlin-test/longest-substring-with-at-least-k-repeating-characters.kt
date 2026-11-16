package longestsubstringwithatleastkrepeatingcharacters

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubstringWithAtLeastKRepeatingCharactersTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(3, solution.longestSubstring("aaabb", 3))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(5, solution.longestSubstring("ababbc", 2))
    }

    @Test
    fun testKEqualsOne() {
        assertEquals(6, solution.longestSubstring("abcdef", 1))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(1, solution.longestSubstring("a", 1))
        assertEquals(0, solution.longestSubstring("a", 2))
    }

    @Test
    fun testNoValidSubstring() {
        assertEquals(0, solution.longestSubstring("abc", 2))
    }

    @Test
    fun testRepeatedWholeString() {
        assertEquals(4, solution.longestSubstring("aaaa", 2))
    }
}
