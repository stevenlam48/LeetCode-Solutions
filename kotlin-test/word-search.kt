package wordsearch

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordSearchTest {
    private fun boardOf(vararg rows: String): Array<CharArray> {
        return rows.map { it.toCharArray() }.toTypedArray()
    }

    @Test
    fun examples() {
        val board = boardOf("ABCE", "SFCS", "ADEE")
        assertTrue(Solution().exist(board, "ABCCED"))
        assertTrue(Solution().exist(board, "SEE"))
        assertFalse(Solution().exist(board, "ABCB"))
    }

    @Test
    fun singleCell() {
        assertTrue(Solution().exist(boardOf("a"), "a"))
        assertFalse(Solution().exist(boardOf("a"), "b"))
    }

    @Test
    fun cannotReuseCell() {
        assertFalse(Solution().exist(boardOf("a"), "aa"))
        assertTrue(Solution().exist(boardOf("aba"), "aba"))
    }

    @Test
    fun emptyWordOnNonemptyBoard() {
        assertTrue(Solution().exist(boardOf("a"), ""))
    }
}
