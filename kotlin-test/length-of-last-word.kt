package lengthoflastword

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LengthOfLastWordTest {
    @Test
    fun findsLastWordInFirstExample() {
        assertEquals(5, Solution().lengthOfLastWord("Hello World"))
    }

    @Test
    fun ignoresSpacesAroundLastWord() {
        assertEquals(4, Solution().lengthOfLastWord("   fly me   to   the moon  "))
    }

    @Test
    fun findsLastWordInThirdExample() {
        assertEquals(6, Solution().lengthOfLastWord("luffy is still joyboy"))
    }

    @Test
    fun returnsZeroForEmptyOrBlankString() {
        assertEquals(0, Solution().lengthOfLastWord(""))
        assertEquals(0, Solution().lengthOfLastWord("   "))
    }

    @Test
    fun returnsLengthOfSingleWord() {
        assertEquals(1, Solution().lengthOfLastWord("a"))
        assertEquals(6, Solution().lengthOfLastWord("kotlin "))
    }
}
