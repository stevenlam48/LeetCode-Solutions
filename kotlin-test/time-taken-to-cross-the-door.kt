package timetakentocrossthedoor

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TimeTakenToCrossTheDoorTest {
    private val solution = Solution()

    @Test
    fun standardInput() {
        assertArrayEquals(intArrayOf(0, 3, 1, 2, 4), solution.timeTaken(intArrayOf(0, 1, 1, 2, 4), intArrayOf(0, 1, 0, 0, 1)))
    }

    @Test
    fun sameArrivalTimeUsesExitPriority() {
        assertArrayEquals(intArrayOf(0, 2, 1), solution.timeTaken(intArrayOf(0, 0, 0), intArrayOf(1, 0, 1)))
    }

    @Test
    fun idleDoorDefaultsToExiting() {
        assertArrayEquals(intArrayOf(0, 3, 4), solution.timeTaken(intArrayOf(0, 3, 4), intArrayOf(0, 1, 0)))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(IntArray(0), solution.timeTaken(IntArray(0), IntArray(0)))
    }
}
