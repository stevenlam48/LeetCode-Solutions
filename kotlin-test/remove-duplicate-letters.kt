package removeduplicateletters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicateLettersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("abc", solution.removeDuplicateLetters("bcabc"))
    }

    @Test
    fun testExample2() {
        assertEquals("acdb", solution.removeDuplicateLetters("cbacdcbc"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("a", solution.removeDuplicateLetters("a"))
    }

    @Test
    fun testAllSameCharacter() {
        assertEquals("a", solution.removeDuplicateLetters("aaaa"))
    }

    @Test
    fun testRepeatedPattern() {
        assertEquals("abc", solution.removeDuplicateLetters("abacb"))
    }
}
