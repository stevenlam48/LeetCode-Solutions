package meetingrooms

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MeetingRoomsTest {
    @Test
    fun overlappingMeetings() {
        val intervals = arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))
        assertFalse(Solution().canAttendMeetings(intervals))
    }

    @Test
    fun nonOverlappingMeetings() {
        val intervals = arrayOf(intArrayOf(7, 10), intArrayOf(2, 4))
        assertTrue(Solution().canAttendMeetings(intervals))
    }

    @Test
    fun touchingMeetingsDoNotOverlap() {
        val intervals = arrayOf(intArrayOf(5, 8), intArrayOf(1, 5), intArrayOf(8, 10))
        assertTrue(Solution().canAttendMeetings(intervals))
    }

    @Test
    fun emptyAndSingleMeeting() {
        assertTrue(Solution().canAttendMeetings(emptyArray()))
        assertTrue(Solution().canAttendMeetings(arrayOf(intArrayOf(1, 2))))
    }
}
