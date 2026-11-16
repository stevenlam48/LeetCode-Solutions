package meetingroomsiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MeetingRoomsIiiTest {
    @Test
    fun exampleOne() {
        val meetings = arrayOf(intArrayOf(0, 10), intArrayOf(1, 5), intArrayOf(2, 7), intArrayOf(3, 4))
        assertEquals(0, Solution().mostBooked(2, meetings))
    }

    @Test
    fun exampleTwo() {
        val meetings = arrayOf(intArrayOf(1, 20), intArrayOf(2, 10), intArrayOf(3, 5), intArrayOf(4, 9), intArrayOf(6, 8))
        assertEquals(1, Solution().mostBooked(3, meetings))
    }

    @Test
    fun tiesUseLowestRoomNumber() {
        val meetings = arrayOf(intArrayOf(0, 10), intArrayOf(1, 11), intArrayOf(2, 12))
        assertEquals(0, Solution().mostBooked(2, meetings))
    }

    @Test
    fun delayedMeetingsExtendEarliestRoom() {
        val meetings = arrayOf(intArrayOf(0, 100), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
        assertEquals(1, Solution().mostBooked(2, meetings))
    }
}
