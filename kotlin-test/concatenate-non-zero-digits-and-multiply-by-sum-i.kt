package concatenatenonzerodigitsandmultiplybysumi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenateNonZeroDigitsAndMultiplyBySumITest {
    @Test
    fun removesZeroDigitsBeforeMultiplying() {
        assertEquals(12340L, Solution().sumAndMultiply(1020304))
    }

    @Test
    fun handlesLeadingPowerOfTenAndAllZeroDigits() {
        assertEquals(1L, Solution().sumAndMultiply(1000))
        assertEquals(0L, Solution().sumAndMultiply(0))
    }

    @Test
    fun handlesNumberWithoutZeroes() {
        assertEquals(6840L, Solution().sumAndMultiply(456))
    }
}
