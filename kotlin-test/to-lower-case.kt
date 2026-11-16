package tolowercase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToLowerCaseTest {
    private val solution = Solution()

    @Test
    fun simpleWord() {
        assertEquals("hello", solution.toLowerCase("Hello"))
    }

    @Test
    fun wordWithSpaces() {
        assertEquals("here", solution.toLowerCase("here"))
    }

    @Test
    fun mixedUppercase() {
        assertEquals("lovely", solution.toLowerCase("LOVELY"))
    }

    @Test
    fun preservesNonAsciiLettersAndSymbols() {
        assertEquals("a-é水😀z", solution.toLowerCase("A-é水😀Z"))
    }

    @Test
    fun emptyString() {
        assertEquals("", solution.toLowerCase(""))
    }
}
