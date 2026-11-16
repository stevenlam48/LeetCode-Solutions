package timetocrossabridge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeToCrossABridgeTest {
    private val solution = Solution()

    @Test
    fun standardSingleBox() {
        val time = arrayOf(intArrayOf(1, 1, 2, 1), intArrayOf(1, 1, 3, 1), intArrayOf(1, 1, 4, 1))
        assertEquals(6, solution.findCrossingTime(1, 3, time))
    }

    @Test
    fun standardMultipleBoxes() {
        val time = arrayOf(intArrayOf(1, 9, 1, 8), intArrayOf(10, 10, 10, 10))
        assertEquals(50, solution.findCrossingTime(3, 2, time))
    }

    @Test
    fun singleWorkerTwoBoxes() {
        val time = arrayOf(intArrayOf(1, 2, 3, 4))
        assertEquals(16, solution.findCrossingTime(2, 1, time))
    }
}
