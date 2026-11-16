package longestsubstringwithatmostkdistinctcharacters

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubstringWithAtMostKDistinctCharactersTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(3, solution.lengthOfLongestSubstringKDistinct("eceba", 2))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(2, solution.lengthOfLongestSubstringKDistinct("aa", 1))
    }

    @Test
    fun testEmptyString() {
        assertEquals(0, solution.lengthOfLongestSubstringKDistinct("", 3))
    }

    @Test
    fun testKGreaterThanDistinctCount() {
        assertEquals(3, solution.lengthOfLongestSubstringKDistinct("abc", 3))
        assertEquals(3, solution.lengthOfLongestSubstringKDistinct("abc", 5))
    }

    @Test
    fun testSlidingWindowShrinks() {
        assertEquals(4, solution.lengthOfLongestSubstringKDistinct("abaccc", 2))
    }

    @Test
    fun testKEqualsZero() {
        assertEquals(0, solution.lengthOfLongestSubstringKDistinct("abc", 0))
    }
}
