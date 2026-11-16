package reschedulemeetingsformaximumfreetimeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RescheduleMeetingsForMaximumFreeTimeIITest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxFreeTime(5, intArrayOf(1, 3), intArrayOf(2, 5)))
    }

    @Test
    fun example2() {
        assertEquals(7, Solution().maxFreeTime(10, intArrayOf(0, 7, 9), intArrayOf(1, 8, 10)))
    }

    @Test
    fun example3() {
        assertEquals(6, Solution().maxFreeTime(10, intArrayOf(0, 3, 7, 9), intArrayOf(1, 4, 8, 10)))
    }

    @Test
    fun example4() {
        assertEquals(0, Solution().maxFreeTime(5, intArrayOf(0, 1, 2, 3, 4), intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun singleMeeting() {
        assertEquals(7, Solution().maxFreeTime(10, intArrayOf(4), intArrayOf(7)))
    }

    @Test
    fun meetingFillsWholeTime() {
        assertEquals(0, Solution().maxFreeTime(5, intArrayOf(0), intArrayOf(5)))
    }
}
