package numberofdaysinamonth

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfDaysInAMonthTest {
    @Test
    fun example1() {
        assertEquals(31, Solution().numberOfDays(1992, 7))
    }

    @Test
    fun leapYearFebruary() {
        assertEquals(29, Solution().numberOfDays(2000, 2))
    }

    @Test
    fun centuryNonLeapYearFebruary() {
        assertEquals(28, Solution().numberOfDays(1900, 2))
    }

    @Test
    fun ordinaryFebruary() {
        assertEquals(28, Solution().numberOfDays(2023, 2))
    }

    @Test
    fun thirtyDayMonth() {
        assertEquals(30, Solution().numberOfDays(2024, 4))
    }
}
