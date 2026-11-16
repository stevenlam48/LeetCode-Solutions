package meetingroomsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MeetingRoomsIiTest {
    @Test
    fun twoRoomsRequired() {
        val intervals = arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))
        assertEquals(2, Solution().minMeetingRooms(intervals))
    }

    @Test
    fun oneRoomRequired() {
        val intervals = arrayOf(intArrayOf(7, 10), intArrayOf(2, 4))
        assertEquals(1, Solution().minMeetingRooms(intervals))
    }

    @Test
    fun touchingMeetingsReuseRooms() {
        val intervals = arrayOf(intArrayOf(1, 5), intArrayOf(5, 8), intArrayOf(8, 9))
        assertEquals(1, Solution().minMeetingRooms(intervals))
    }

    @Test
    fun nestedMeetings() {
        val intervals = arrayOf(intArrayOf(1, 10), intArrayOf(2, 7), intArrayOf(3, 19), intArrayOf(8, 12))
        assertEquals(3, Solution().minMeetingRooms(intervals))
    }

    @Test
    fun noMeetings() {
        assertEquals(0, Solution().minMeetingRooms(emptyArray()))
    }
}
