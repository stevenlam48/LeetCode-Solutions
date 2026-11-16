package longestwordwithallprefixes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestWordWithAllPrefixesTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(
            "world",
            solution.longestWord(arrayOf("w", "wo", "wor", "worl", "world"))
        )
    }

    @Test
    fun testExampleTwo() {
        assertEquals(
            "apple",
            solution.longestWord(
                arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple")
            )
        )
    }

    @Test
    fun testMissingPrefix() {
        assertEquals("", solution.longestWord(arrayOf("ab", "bc", "abc")))
    }

    @Test
    fun testSingleWord() {
        assertEquals("a", solution.longestWord(arrayOf("a")))
    }

    @Test
    fun testEmptyInput() {
        assertEquals("", solution.longestWord(arrayOf()))
    }

    @Test
    fun testTieUsesLexicographicOrder() {
        assertEquals("ab", solution.longestWord(arrayOf("a", "ab", "ac")))
    }
}
