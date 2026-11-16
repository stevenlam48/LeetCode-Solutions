package validnumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidNumberTest {
    @Test
    fun leetCodeValidExamples() {
        assertTrue(Solution().isNumber("0"))
        assertTrue(Solution().isNumber("2e10"))
        assertTrue(Solution().isNumber(" -90e3   "))
        assertTrue(Solution().isNumber("53.5e93"))
    }

    @Test
    fun leetCodeInvalidExamples() {
        assertFalse(Solution().isNumber("e"))
        assertFalse(Solution().isNumber("."))
        assertFalse(Solution().isNumber("1e"))
    }

    @Test
    fun leadingDotOrSignIsValid() {
        assertTrue(Solution().isNumber("+.8"))
        assertTrue(Solution().isNumber("-0.1"))
        assertTrue(Solution().isNumber(".5"))
    }

    @Test
    fun leadingAndTrailingSpaces() {
        assertTrue(Solution().isNumber(" 1"))
        assertTrue(Solution().isNumber("1 "))
        assertFalse(Solution().isNumber("12 3"))
    }

    @Test
    fun exponentSignHandling() {
        assertTrue(Solution().isNumber("1e-3"))
        assertFalse(Solution().isNumber("1e+"))
        assertFalse(Solution().isNumber("++1"))
    }

    @Test
    fun nonNumericInput() {
        assertFalse(Solution().isNumber("abc"))
        assertFalse(Solution().isNumber("1a"))
    }
}
