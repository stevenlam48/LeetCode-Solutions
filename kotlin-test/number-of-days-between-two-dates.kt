package numberofdaysbetweentwodates

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfDaysBetweenTwoDatesTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().daysBetweenDates("2019-06-29", "2019-06-30"))
    }

    @Test
    fun example2() {
        assertEquals(15, Solution().daysBetweenDates("2020-01-15", "2019-12-31"))
    }

    @Test
    fun leapYearFebruary() {
        assertEquals(2, Solution().daysBetweenDates("2020-02-28", "2020-03-01"))
    }

    @Test
    fun nonLeapYearFebruary() {
        assertEquals(1, Solution().daysBetweenDates("2019-02-28", "2019-03-01"))
    }

    @Test
    fun reversedDatesAndSameDate() {
        assertEquals(15, Solution().daysBetweenDates("2019-12-31", "2020-01-15"))
        assertEquals(0, Solution().daysBetweenDates("2024-02-29", "2024-02-29"))
    }
}
