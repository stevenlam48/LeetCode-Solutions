package maximumdifferencebyremappingadigit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumDifferenceByRemappingADigitTest {
    @Test
    fun exampleWithMultipleReplaceableDigits() {
        assertEquals(99009, Solution().minMaxDifference(11891))
    }

    @Test
    fun exampleEndingInZero() {
        assertEquals(99, Solution().minMaxDifference(90))
    }

    @Test
    fun zero() {
        assertEquals(0, Solution().minMaxDifference(0))
    }

    @Test
    fun repeatedDigit() {
        assertEquals(999, Solution().minMaxDifference(777))
    }
}
