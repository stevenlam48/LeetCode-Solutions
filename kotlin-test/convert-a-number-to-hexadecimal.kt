package convertanumbertohexadecimal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertANumberToHexadecimalTest {
    @Test
    fun positiveNumber() {
        assertEquals("1a", Solution().toHex(26))
    }

    @Test
    fun negativeNumberUsesTwosComplement() {
        assertEquals("ffffffff", Solution().toHex(-1))
    }

    @Test
    fun zero() {
        assertEquals("0", Solution().toHex(0))
    }

    @Test
    fun minimumIntegerHasEightHexDigits() {
        assertEquals("80000000", Solution().toHex(Int.MIN_VALUE))
    }
}
