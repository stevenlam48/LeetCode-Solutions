package longestwordindictionary

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestWordInDictionaryTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals("world", solution.longestWord(arrayOf("w", "wo", "wor", "worl", "world")))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(
            "apple",
            solution.longestWord(arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple"))
        )
    }

    @Test
    fun testMissingSingleLetterPrefix() {
        assertEquals("", solution.longestWord(arrayOf("ab", "bc", "abc")))
    }

    @Test
    fun testSingleWord() {
        assertEquals("a", solution.longestWord(arrayOf("a")))
    }

    @Test
    fun testLexicographicTieBreak() {
        assertEquals("a", solution.longestWord(arrayOf("a", "b")))
        assertEquals("ab", solution.longestWord(arrayOf("a", "ab", "ac")))
    }

    @Test
    fun testAllPrefixesPresent() {
        assertEquals("abc", solution.longestWord(arrayOf("abc", "ab", "a")))
    }
}
