package longestuncommonsubsequenceii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestUncommonSubsequenceIITest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(3, solution.findLUSlength(arrayOf("aba", "cdc", "eae")))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(-1, solution.findLUSlength(arrayOf("aaa", "aaa", "aa")))
    }

    @Test
    fun testDuplicatesOfLongest() {
        assertEquals(-1, solution.findLUSlength(arrayOf("abcd", "abcd", "ab")))
    }

    @Test
    fun testSingleElement() {
        assertEquals(3, solution.findLUSlength(arrayOf("abc")))
    }

    @Test
    fun testAllDistinctLengths() {
        assertEquals(4, solution.findLUSlength(arrayOf("a", "ab", "abc", "abcd")))
    }

    @Test
    fun testNoCommonCharacters() {
        assertEquals(1, solution.findLUSlength(arrayOf("a", "b")))
    }
}
