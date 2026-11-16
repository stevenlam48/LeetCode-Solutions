package wordsquaresii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordSquaresIiTest {
    @Test
    fun findsMatchingFourWords() {
        assertEquals(
            listOf(
                listOf("aaab", "accd", "bzzd", "ddxd"),
                listOf("accd", "aaab", "ddxd", "bzzd")
            ),
            Solution().wordSquares(listOf("ddxd", "bzzd", "accd", "aaab"))
        )
    }

    @Test
    fun sortsInputForDeterministicOutput() {
        val expected = listOf(
                listOf("aaab", "accd", "bzzd", "ddxd"),
                listOf("accd", "aaab", "ddxd", "bzzd")
            )
        assertEquals(expected, Solution().wordSquares(listOf("aaab", "accd", "bzzd", "ddxd")))
        assertEquals(expected, Solution().wordSquares(listOf("accd", "aaab", "ddxd", "bzzd")))
    }

    @Test
    fun requiresFourDistinctIndices() {
        assertTrue(Solution().wordSquares(listOf("aaaa")).isEmpty())
    }

    @Test
    fun noMatch() {
        assertTrue(Solution().wordSquares(listOf("aaab", "accd", "bzzc", "ddxd")).isEmpty())
    }
}
