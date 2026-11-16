package wordsearchii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordSearchIiTest {
    private fun boardOf(vararg rows: String): Array<CharArray> {
        return rows.map { it.toCharArray() }.toTypedArray()
    }

    @Test
    fun example() {
        val result = Solution().findWords(
            boardOf("oaan", "etae", "ihkr", "iflv"),
            listOf("oath", "pea", "eat", "rain")
        )
        assertEquals(setOf("oath", "eat"), result.toSet())
        assertEquals(2, result.size)
    }

    @Test
    fun singleCell() {
        assertEquals(listOf("a"), Solution().findWords(boardOf("a"), listOf("a", "aa")))
    }

    @Test
    fun duplicateDictionaryWords() {
        val result = Solution().findWords(boardOf("aa"), listOf("a", "a", "aa"))
        assertEquals(setOf("a", "aa"), result.toSet())
        assertEquals(2, result.size)
    }

    @Test
    fun noMatches() {
        assertTrue(Solution().findWords(boardOf("ab", "cd"), listOf("ad", "bc", "aba")).isEmpty())
    }
}
