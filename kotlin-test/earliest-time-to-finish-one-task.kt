package earliesttimetofinishonetask

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EarliestTimeToFinishOneTaskTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().earliestTime(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 2))))
    }

    @Test
    fun singleTask() {
        assertEquals(10, Solution().earliestTime(arrayOf(intArrayOf(5, 5))))
    }

    @Test
    fun tie() {
        assertEquals(2, Solution().earliestTime(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun laterStartShorterDuration() {
        assertEquals(5, Solution().earliestTime(arrayOf(intArrayOf(4, 1), intArrayOf(9, 9))))
    }
}
