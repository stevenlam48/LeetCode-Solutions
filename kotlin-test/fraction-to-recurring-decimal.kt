package fractiontorecurringdecimal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FractionToRecurringDecimalTest {
    private val solution = Solution()

    @Test
    fun terminatingDecimal() {
        assertEquals("0.5", solution.fractionToDecimal(1, 2))
        assertEquals("-6.25", solution.fractionToDecimal(-50, 8))
    }

    @Test
    fun integerAndZeroResults() {
        assertEquals("2", solution.fractionToDecimal(2, 1))
        assertEquals("0", solution.fractionToDecimal(0, -7))
        assertEquals("0.5", solution.fractionToDecimal(-2, -4))
    }

    @Test
    fun recurringDecimals() {
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333))
        assertEquals("0.1(6)", solution.fractionToDecimal(1, 6))
    }

    @Test
    fun negativeDenominatorSetSign() {
        assertEquals("-0.5", solution.fractionToDecimal(1, -2))
        assertEquals("2", solution.fractionToDecimal(-2, -1))
    }

    @Test
    fun minimumIntUsesWideArithmetic() {
        assertEquals("2147483648", solution.fractionToDecimal(Int.MIN_VALUE, -1))
        assertEquals("-2147483648", solution.fractionToDecimal(Int.MIN_VALUE, 1))
    }
}
