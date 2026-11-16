package validdigitnumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidDigitNumberTest {
    @Test
    fun digitAppearsAwayFromLeadingPosition() {
        assertTrue(Solution().validDigit(121, 2))
        assertTrue(Solution().validDigit(100, 0))
    }

    @Test
    fun digitAppearsOnlyAtLeadingPosition() {
        assertFalse(Solution().validDigit(121, 1))
    }

    @Test
    fun digitIsAbsent() {
        assertFalse(Solution().validDigit(123, 4))
    }

    @Test
    fun zeroAndNegativeInputs() {
        assertFalse(Solution().validDigit(0, 0))
        assertFalse(Solution().validDigit(-121, 1))
    }
}
