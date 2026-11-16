package computedecimalrepresentation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ComputeDecimalRepresentationTest {
    @Test
    fun splitsEveryNonZeroDecimalPlace() {
        assertArrayEquals(intArrayOf(500, 30, 7), Solution().decimalRepresentation(537))
    }

    @Test
    fun skipsZeroDigits() {
        assertArrayEquals(intArrayOf(100, 2), Solution().decimalRepresentation(102))
        assertArrayEquals(intArrayOf(1000000, 20000, 300), Solution().decimalRepresentation(1020300))
    }

    @Test
    fun handlesSingleDigitAndZero() {
        assertArrayEquals(intArrayOf(6), Solution().decimalRepresentation(6))
        assertArrayEquals(intArrayOf(), Solution().decimalRepresentation(0))
    }
}
