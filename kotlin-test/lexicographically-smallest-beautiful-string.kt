package lexicographicallysmallestbeautifulstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestBeautifulStringTest {
    @Test
    fun example1() {
        assertEquals("abda", Solution().smallestBeautifulString("abcz", 26))
    }

    @Test
    fun impossible() {
        assertEquals("", Solution().smallestBeautifulString("dc", 4))
    }

    @Test
    fun twoLetters() {
        assertEquals("ba", Solution().smallestBeautifulString("ab", 2))
    }

    @Test
    fun lastLetterOfAlphabet() {
        assertEquals("", Solution().smallestBeautifulString("c", 3))
    }
}
