package validword

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidWordTest {
    @Test
    fun leetCodeExamples() {
        assertTrue(Solution().isValid("234Adas"))
        assertFalse(Solution().isValid("b3"))
        assertFalse(Solution().isValid("a3\$e"))
    }

    @Test
    fun tooShort() {
        assertFalse(Solution().isValid("a1"))
        assertFalse(Solution().isValid(""))
    }

    @Test
    fun needsBothVowelAndConsonant() {
        assertFalse(Solution().isValid("aei"))
        assertFalse(Solution().isValid("BCD"))
        assertTrue(Solution().isValid("AhI"))
    }

    @Test
    fun digitsAllowedInBetween() {
        assertTrue(Solution().isValid("A1b"))
        assertFalse(Solution().isValid("234"))
    }
}
