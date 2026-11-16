package dayoftheweek

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayOfTheWeekTest {
    @Test
    fun example1() {
        assertEquals("Sunday", Solution().dayOfTheWeek(18, 8, 2019))
    }

    @Test
    fun example2() {
        assertEquals("Saturday", Solution().dayOfTheWeek(31, 8, 2019))
    }

    @Test
    fun unixEpoch() {
        assertEquals("Thursday", Solution().dayOfTheWeek(1, 1, 1970))
    }

    @Test
    fun leapDay() {
        assertEquals("Monday", Solution().dayOfTheWeek(29, 2, 2016))
    }

    @Test
    fun centuryBoundaries() {
        assertEquals("Saturday", Solution().dayOfTheWeek(1, 1, 2000))
        assertEquals("Monday", Solution().dayOfTheWeek(1, 1, 1900))
    }

    @Test
    fun endOfYear() {
        assertEquals("Friday", Solution().dayOfTheWeek(31, 12, 1999))
    }
}
