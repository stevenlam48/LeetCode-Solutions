package longestsubstringwithatmosttwodistinctcharacters

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubstringWithAtMostTwoDistinctCharactersTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(3, solution.lengthOfLongestSubstringTwoDistinct("eceba"))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(5, solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"))
    }

    @Test
    fun testEmptyString() {
        assertEquals(0, solution.lengthOfLongestSubstringTwoDistinct(""))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(1, solution.lengthOfLongestSubstringTwoDistinct("a"))
    }

    @Test
    fun testTwoCharacters() {
        assertEquals(2, solution.lengthOfLongestSubstringTwoDistinct("ab"))
    }

    @Test
    fun testThreeDistinctCharacters() {
        assertEquals(2, solution.lengthOfLongestSubstringTwoDistinct("abc"))
    }
}
