package reschedulemeetingsformaximumfreetimei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RescheduleMeetingsForMaximumFreeTimeITest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxFreeTime(5, 1, intArrayOf(1, 3), intArrayOf(2, 5)))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().maxFreeTime(10, 1, intArrayOf(0, 2, 9), intArrayOf(1, 4, 10)))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().maxFreeTime(5, 2, intArrayOf(0, 1, 2, 3, 4), intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun moveOneOfThreeMeetings() {
        assertEquals(7, Solution().maxFreeTime(10, 1, intArrayOf(0, 5, 9), intArrayOf(1, 6, 10)))
    }

    @Test
    fun noMovesAllowed() {
        assertEquals(5, Solution().maxFreeTime(10, 0, intArrayOf(0, 2, 9), intArrayOf(1, 4, 10)))
    }

    @Test
    fun singleMeeting() {
        assertEquals(3, Solution().maxFreeTime(5, 0, intArrayOf(1), intArrayOf(2)))
    }
}
