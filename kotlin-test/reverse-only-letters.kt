package reverseonlyletters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseOnlyLettersTest {
    @Test
    fun lettersWithHyphen() {
        assertEquals("dc-ba", Solution().reverseOnlyLetters("ab-cd"))
    }

    @Test
    fun mixedPunctuation() {
        assertEquals("j-Ih-gfE-dCba", Solution().reverseOnlyLetters("a-bC-dEf-ghIj"))
    }

    @Test
    fun punctuationOnly() {
        assertEquals("123--", Solution().reverseOnlyLetters("123--"))
    }

    @Test
    fun emptyString() {
        assertEquals("", Solution().reverseOnlyLetters(""))
    }
}
