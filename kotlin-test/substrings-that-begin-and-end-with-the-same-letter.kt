package substringsthatbeginandendwiththesameletter

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubstringsThatBeginAndEndWithTheSameLetterTest {
    @Test
    fun exampleOne() {
        assertEquals(7L, Solution().numberOfSubstrings("abcba"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(9L, Solution().numberOfSubstrings("abacad"))
    }

    @Test
    fun allSameCharacter() {
        assertEquals(15L, Solution().numberOfSubstrings("aaaaa"))
    }

    @Test
    fun emptyAndSingleCharacter() {
        assertEquals(0L, Solution().numberOfSubstrings(""))
        assertEquals(1L, Solution().numberOfSubstrings("z"))
    }
}
