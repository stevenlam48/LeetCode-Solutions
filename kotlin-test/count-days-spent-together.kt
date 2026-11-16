package countdaysspenttogether

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDaysSpentTogetherTest {
    @Test
    fun overlappingTrips() {
        assertEquals(3, Solution().countDaysTogether("08-15", "08-18", "08-16", "08-19"))
    }

    @Test
    fun sameFullMonth() {
        assertEquals(31, Solution().countDaysTogether("10-01", "10-31", "10-01", "10-31"))
    }

    @Test
    fun noOverlap() {
        assertEquals(0, Solution().countDaysTogether("08-15", "08-18", "09-01", "09-10"))
    }

    @Test
    fun singleSharedDay() {
        assertEquals(1, Solution().countDaysTogether("08-15", "08-15", "08-15", "08-15"))
    }

    @Test
    fun crossMonthOverlap() {
        assertEquals(2, Solution().countDaysTogether("12-22", "12-25", "12-24", "12-26"))
    }
}
