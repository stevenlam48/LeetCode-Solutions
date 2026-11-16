package latesttimebyreplacinghiddendigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LatestTimeByReplacingHiddenDigitsTest {
    private val solution = Solution()

    @Test
    fun hiddenHourAndMinuteDigits() {
        assertEquals("23:50", solution.maximumTime("2?:?0"))
    }

    @Test
    fun fullyHiddenTime() {
        assertEquals("23:59", solution.maximumTime("??:??"))
    }

    @Test
    fun hiddenHourAndHiddenMinuteDigit() {
        assertEquals("23:39", solution.maximumTime("??:3?"))
    }

    @Test
    fun firstHourDigitDependsOnSecond() {
        assertEquals("14:09", solution.maximumTime("?4:0?"))
        assertEquals("09:39", solution.maximumTime("0?:3?"))
    }

    @Test
    fun alreadyFullyVisibleTime() {
        assertEquals("07:05", solution.maximumTime("07:05"))
    }
}
