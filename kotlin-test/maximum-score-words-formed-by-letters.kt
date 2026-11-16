package maximumscorewordsformedbyletters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreWordsFormedByLettersTest {
    private val score = intArrayOf(
        1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    )

    @Test
    fun example1() {
        val words = arrayOf("dog", "cat", "dad", "good")
        val letters = charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o')
        assertEquals(23, Solution().maxScoreWords(words, letters, score))
    }

    @Test
    fun limitedLetters() {
        val words = arrayOf("a", "aa", "aaa")
        val letters = charArrayOf('a', 'a')
        val s = IntArray(26).also { it[0] = 1 }
        assertEquals(2, Solution().maxScoreWords(words, letters, s))
    }

    @Test
    fun noLetters() {
        val words = arrayOf("a")
        val s = IntArray(26).also { it[0] = 1 }
        assertEquals(0, Solution().maxScoreWords(words, charArrayOf(), s))
    }

    @Test
    fun chooseBestCombination() {
        val words = arrayOf("ab", "bc")
        val letters = charArrayOf('a', 'b', 'c')
        val s = IntArray(26).also {
            it[0] = 1
            it[1] = 2
            it[2] = 3
        }
        assertEquals(5, Solution().maxScoreWords(words, letters, s))
    }

    @Test
    fun zeroScoreWord() {
        val words = arrayOf("x")
        val letters = charArrayOf('x')
        assertEquals(0, Solution().maxScoreWords(words, letters, IntArray(26)))
    }
}
