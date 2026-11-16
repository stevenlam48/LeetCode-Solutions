package findthesequenceofstringsappearedonthescreen

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSequenceOfStringsAppearedOnTheScreenTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            listOf("a", "aa", "ab", "aba", "abb", "abc"),
            solution.stringSequence("abc")
        )
    }

    @Test
    fun testRepeatedLetters() {
        assertEquals(
            listOf("a", "aa", "aaa", "aaaa", "aaaaa"),
            solution.stringSequence("aaaaa")
        )
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(listOf("a"), solution.stringSequence("a"))
        assertEquals(listOf("a", "b"), solution.stringSequence("b"))
    }

    @Test
    fun testLastLetter() {
        assertEquals(
            listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                   "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"),
            solution.stringSequence("z")
        )
    }
}
