package confusingnumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConfusingNumberTest {
    @Test
    fun recognizesSingleDigitConfusingNumbers() {
        assertTrue(Solution().confusingNumber(6))
        assertTrue(Solution().confusingNumber(9))
    }

    @Test
    fun recognizesMultiDigitRotationChanges() {
        assertTrue(Solution().confusingNumber(89))
        assertTrue(Solution().confusingNumber(10))
    }

    @Test
    fun rejectsUnchangedRotations() {
        assertFalse(Solution().confusingNumber(11))
        assertFalse(Solution().confusingNumber(818))
    }

    @Test
    fun rejectsDigitsWithoutRotations() {
        assertFalse(Solution().confusingNumber(25))
        assertFalse(Solution().confusingNumber(167))
    }
}
