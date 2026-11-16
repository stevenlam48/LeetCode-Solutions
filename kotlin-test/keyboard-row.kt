package keyboardrow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KeyboardRowTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(
            listOf("Alaska", "Dad"),
            solution.findWords(listOf("Hello", "Alaska", "Dad", "Peace"))
        )
    }

    @Test
    fun noWords() {
        assertEquals(emptyList<String>(), solution.findWords(listOf("omk")))
    }

    @Test
    fun sameRowWords() {
        assertEquals(listOf("adsdf", "sfd"), solution.findWords(listOf("adsdf", "sfd")))
    }

    @Test
    fun singleLetters() {
        assertEquals(listOf("a", "b"), solution.findWords(listOf("a", "b")))
    }

    @Test
    fun oneWordPerRow() {
        assertEquals(
            listOf("qwerty", "asdfgh", "zxcvbn"),
            solution.findWords(listOf("qwerty", "asdfgh", "zxcvbn"))
        )
    }

    @Test
    fun uppercase() {
        assertEquals(listOf("A", "a"), solution.findWords(listOf("A", "a")))
    }
}
