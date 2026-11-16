package sentencescreenfitting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SentenceScreenFittingTest {
    @Test
    fun exampleHelloWorld() {
        assertEquals(1, Solution().wordsTyping(listOf("hello", "world"), 2, 8))
    }

    @Test
    fun exampleShortWords() {
        assertEquals(2, Solution().wordsTyping(listOf("a", "bcd", "e"), 3, 6))
    }

    @Test
    fun exampleApplePie() {
        assertEquals(1, Solution().wordsTyping(listOf("i", "had", "apple", "pie"), 4, 5))
    }

    @Test
    fun singleWordManyRows() {
        assertEquals(2, Solution().wordsTyping(listOf("a"), 2, 1))
    }

    @Test
    fun wordTooWide() {
        assertEquals(0, Solution().wordsTyping(listOf("abc"), 1, 2))
    }

    @Test
    fun oneRowFitsSeveralCopies() {
        assertEquals(2, Solution().wordsTyping(listOf("a"), 1, 3))
    }
}
