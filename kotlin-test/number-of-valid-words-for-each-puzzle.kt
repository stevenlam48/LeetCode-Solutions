package numberofvalidwordsforeachpuzzle

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfValidWordsForEachPuzzleTest {
    @Test
    fun example1() {
        val words = listOf("aaaa", "asas", "able", "ability", "actt", "actor", "access")
        val puzzles = listOf("aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz")
        assertArrayEquals(intArrayOf(1, 1, 3, 2, 4, 0), Solution().findNumOfValidWords(words, puzzles))
    }

    @Test
    fun singleMatch() {
        assertArrayEquals(intArrayOf(1), Solution().findNumOfValidWords(listOf("apple"), listOf("aplez")))
    }

    @Test
    fun wordContainsLetterOutsidePuzzle() {
        assertArrayEquals(intArrayOf(0), Solution().findNumOfValidWords(listOf("abc"), listOf("bcde")))
    }

    @Test
    fun wordTooLong() {
        assertArrayEquals(intArrayOf(0), Solution().findNumOfValidWords(listOf("abcdefgh"), listOf("abcdefg")))
    }

    @Test
    fun duplicateLettersInWord() {
        assertArrayEquals(intArrayOf(1), Solution().findNumOfValidWords(listOf("aaa"), listOf("abcde")))
    }
}
