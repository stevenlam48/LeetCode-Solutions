package reversevowelsofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseVowelsOfAStringTest {
    @Test
    fun designText() {
        assertEquals("AceCreIm", Solution().reverseVowels("IceCreAm"))
    }

    @Test
    fun hello() {
        assertEquals("holle", Solution().reverseVowels("hello"))
    }

    @Test
    fun upperAndLowerCase() {
        assertEquals("Aa", Solution().reverseVowels("aA"))
    }

    @Test
    fun noVowels() {
        assertEquals("rhythm", Solution().reverseVowels("rhythm"))
    }
}
