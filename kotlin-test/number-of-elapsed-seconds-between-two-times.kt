package numberofelapsedsecondsbetweentwotimes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfElapsedSecondsBetweenTwoTimesTest {
    @Test
    fun testForward() {
        assertEquals(3600, Solution().secondsBetweenTimes("09:00:00", "10:00:00"))
    }

    @Test
    fun testBackward() {
        assertEquals(-3600, Solution().secondsBetweenTimes("10:00:00", "09:00:00"))
    }

    @Test
    fun testFullDay() {
        assertEquals(86399, Solution().secondsBetweenTimes("00:00:00", "23:59:59"))
    }

    @Test
    fun testSameTime() {
        assertEquals(0, Solution().secondsBetweenTimes("12:34:56", "12:34:56"))
    }
}
