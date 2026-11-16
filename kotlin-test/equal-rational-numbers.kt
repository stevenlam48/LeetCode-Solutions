package equalrationalnumbers

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class EqualRationalNumbersTest {
    private val solution = Solution()

    @Test
    fun repeatingPartCanStartAtDifferentPositions() {
        assertTrue(solution.isRationalEqual("0.(52)", "0.5(25)"))
        assertTrue(solution.isRationalEqual("0.1666(6)", "0.166(66)"))
    }

    @Test
    fun repeatingNinesEqualNextInteger() {
        assertTrue(solution.isRationalEqual("0.9(9)", "1."))
    }

    @Test
    fun finiteAndInfiniteDecimalsAreDifferent() {
        assertFalse(solution.isRationalEqual("0.123", "0.(123)"))
    }

    @Test
    fun negativeFiniteFractionsUseLongArithmetic() {
        assertTrue(solution.isRationalEqual("-0.5", "-0.50"))
        assertFalse(solution.isRationalEqual("-0.5", "-0.4"))
    }

    @Test
    fun valuesBeyondIntRemainExact() {
        assertTrue(solution.isRationalEqual("3000000000", "3000000000.0"))
        assertTrue(solution.isRationalEqual("0.0000000001", "0.00000000010"))
    }
}
