package minimizeroundingerrortomeettarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeRoundingErrorToMeetTargetTest {
    @Test
    fun firstExample() {
        val prices = listOf("0.700", "2.800", "4.900")
        assertEquals("1.000", Solution().minimizeError(prices, 8))
    }

    @Test
    fun lowerTargetChangesRoundedValues() {
        val prices = listOf("0.700", "2.800", "4.900")
        assertEquals("1.600", Solution().minimizeError(prices, 7))
    }

    @Test
    fun duplicateFractions() {
        val prices = listOf("0.100", "0.200", "0.200", "0.900")
        assertEquals("1.200", Solution().minimizeError(prices, 2))
    }

    @Test
    fun integralPricesHaveNoRoundingError() {
        assertEquals("0.000", Solution().minimizeError(listOf("1.000", "2.000"), 3))
    }

    @Test
    fun impossibleTargets() {
        val prices = listOf("1.000", "2.000")
        assertEquals("-1", Solution().minimizeError(prices, 2))
        assertEquals("-1", Solution().minimizeError(prices, 4))
    }

    @Test
    fun outputIsTruncatedToThreeDecimals() {
        assertEquals("0.123", Solution().minimizeError(listOf("0.1239", "1.000"), 1))
    }
}
