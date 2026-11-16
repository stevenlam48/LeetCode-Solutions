package hexspeak

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HexspeakTest {
    @Test
    fun standardValidExample() {
        assertEquals("IOI", Solution().toHexspeak("257"))
    }

    @Test
    fun standardInvalidExample() {
        assertEquals("ERROR", Solution().toHexspeak("3"))
    }

    @Test
    fun lettersAndSubstitutions() {
        assertEquals("ABCDEF", Solution().toHexspeak("11259375"))
    }

    @Test
    fun leadingZeroesInHexadecimalAreOmitted() {
        assertEquals("I", Solution().toHexspeak("1"))
        assertEquals("IOO", Solution().toHexspeak("256"))
    }

    @Test
    fun invalidDigitAnywhereReturnsError() {
        assertEquals("ERROR", Solution().toHexspeak("619"))
    }

    @Test
    fun zeroReturnsEmptyStringAsInReference() {
        assertEquals("", Solution().toHexspeak("0"))
    }
}
