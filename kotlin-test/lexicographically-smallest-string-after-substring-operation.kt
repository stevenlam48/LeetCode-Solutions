package lexicographicallysmalleststringaftersubstringoperation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterSubstringOperationTest {
    @Test
    fun decrementsFirstNonASubstring() {
        assertEquals("baabc", Solution().smallestString("cbabc"))
        assertEquals("abaab", Solution().smallestString("acbbc"))
    }

    @Test
    fun changesLastCharacterWhenAllCharactersAreA() {
        assertEquals("aaaaz", Solution().smallestString("aaaaa"))
    }

    @Test
    fun handlesSingleCharacter() {
        assertEquals("z", Solution().smallestString("a"))
        assertEquals("a", Solution().smallestString("b"))
    }

    @Test
    fun skipsLeadingACharacters() {
        assertEquals("aaba", Solution().smallestString("abca"))
    }
}
