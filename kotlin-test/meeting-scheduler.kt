package meetingscheduler

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MeetingSchedulerTest {
    @Test
    fun exampleOne() {
        val slots1 = arrayOf(intArrayOf(10, 50), intArrayOf(60, 120), intArrayOf(140, 210))
        val slots2 = arrayOf(intArrayOf(0, 15), intArrayOf(60, 70))
        assertArrayEquals(intArrayOf(60, 68), Solution().minAvailableDuration(slots1, slots2, 8))
    }

    @Test
    fun exampleTwo() {
        val slots1 = arrayOf(intArrayOf(10, 50), intArrayOf(60, 120), intArrayOf(140, 210))
        val slots2 = arrayOf(intArrayOf(0, 15), intArrayOf(60, 70))
        assertArrayEquals(intArrayOf(), Solution().minAvailableDuration(slots1, slots2, 12))
    }

    @Test
    fun earliestIntersectionIsReturned() {
        val slots1 = arrayOf(intArrayOf(10, 50))
        val slots2 = arrayOf(intArrayOf(0, 15))
        assertArrayEquals(intArrayOf(10, 15), Solution().minAvailableDuration(slots1, slots2, 5))
    }

    @Test
    fun undersizedSlotsAreIgnoredAndEmptyInputsWork() {
        assertArrayEquals(
            intArrayOf(),
            Solution().minAvailableDuration(arrayOf(intArrayOf(1, 3)), arrayOf(intArrayOf(2, 8)), 5)
        )
        assertArrayEquals(intArrayOf(), Solution().minAvailableDuration(emptyArray(), emptyArray(), 1))
    }
}
