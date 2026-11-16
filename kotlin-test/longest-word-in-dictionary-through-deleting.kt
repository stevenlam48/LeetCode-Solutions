package longestwordindictionarythroughdeleting

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestWordInDictionaryThroughDeletingTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(
            "apple",
            solution.findLongestWord("abpcplea", arrayOf("ale", "apple", "monkey", "plea"))
        )
    }

    @Test
    fun testExampleTwo() {
        assertEquals("", solution.findLongestWord("a", arrayOf("b", "c")))
    }

    @Test
    fun testLexicographicTieBreak() {
        assertEquals("a", solution.findLongestWord("abpcplea", arrayOf("a", "b", "c")))
    }

    @Test
    fun testWholeStringIsWord() {
        assertEquals("aaa", solution.findLongestWord("aaa", arrayOf("aaa", "aa")))
    }

    @Test
    fun testNoSubsequence() {
        assertEquals("", solution.findLongestWord("abc", arrayOf("abd", "acb")))
    }

    @Test
    fun testEmptyDictionary() {
        assertEquals("", solution.findLongestWord("abc", arrayOf()))
    }
}
