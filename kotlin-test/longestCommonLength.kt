package longestCommonLength

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestCommonLengthTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals("fl", solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    }

    @Test
    fun testExampleTwo() {
        assertEquals("", solution.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    }

    @Test
    fun testEmptyInput() {
        assertEquals("", solution.longestCommonPrefix(arrayOf()))
    }

    @Test
    fun testSingleString() {
        assertEquals("abc", solution.longestCommonPrefix(arrayOf("abc")))
    }

    @Test
    fun testShorterStringIsPrefix() {
        assertEquals("a", solution.longestCommonPrefix(arrayOf("ab", "a")))
    }

    @Test
    fun testAllIdentical() {
        assertEquals("same", solution.longestCommonPrefix(arrayOf("same", "same", "same")))
    }
}
