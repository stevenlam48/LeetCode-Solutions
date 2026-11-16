package wordsquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordSquaresTest {
    @Test
    fun example() {
        assertEquals(
            listOf(
                listOf("wall", "area", "lead", "lady"),
                listOf("ball", "area", "lead", "lady")
            ),
            Solution().wordSquares(listOf("area", "lead", "wall", "lady", "ball"))
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            listOf(
                listOf("baba", "abat", "baba", "atan"),
                listOf("baba", "abat", "baba", "atal")
            ),
            Solution().wordSquares(listOf("abat", "baba", "atan", "atal"))
        )
    }

    @Test
    fun singleLetter() {
        assertEquals(listOf(listOf("a")), Solution().wordSquares(listOf("a")))
    }

    @Test
    fun noSquare() {
        assertEquals(emptyList<List<String>>(), Solution().wordSquares(listOf("ab", "cd")))
    }
}
