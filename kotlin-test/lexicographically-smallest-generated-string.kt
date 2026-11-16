package lexicographicallysmallestgeneratedstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestGeneratedStringTest {
    @Test
    fun example1() {
        assertEquals("ababa", Solution().generateString("TFTF", "ab"))
    }

    @Test
    fun example2() {
        assertEquals("", Solution().generateString("TFTF", "abc"))
    }

    @Test
    fun singleFalseLetterNotInPattern() {
        assertEquals("a", Solution().generateString("F", "d"))
    }

    @Test
    fun singleFalseLetterInPattern() {
        assertEquals("b", Solution().generateString("F", "a"))
    }
}
