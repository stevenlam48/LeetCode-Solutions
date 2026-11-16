package countdayswithoutmeetings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDaysWithoutMeetingsTest {
    @Test
    fun example() {
        val meetings = arrayOf(intArrayOf(5, 7), intArrayOf(1, 3), intArrayOf(9, 10))
        assertEquals(2, Solution().countDays(10, meetings))
    }

    @Test
    fun overlappingMeetings() {
        val meetings = arrayOf(intArrayOf(2, 4), intArrayOf(1, 3))
        assertEquals(1, Solution().countDays(5, meetings))
    }

    @Test
    fun fullyBooked() {
        assertEquals(0, Solution().countDays(6, arrayOf(intArrayOf(1, 6))))
    }

    @Test
    fun noMeetings() {
        assertEquals(7, Solution().countDays(7, emptyArray()))
    }

    @Test
    fun unsortedMeetings() {
        val meetings = arrayOf(intArrayOf(8, 9), intArrayOf(1, 2), intArrayOf(4, 5))
        assertEquals(4, Solution().countDays(10, meetings))
    }
}
