package mergeoperationsforminimumtraveltime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeOperationsForMinimumTravelTimeTest {
    @Test
    fun keepEveryPosition() {
        val position = intArrayOf(0, 10, 20)
        val time = intArrayOf(1, 2, 3)
        assertEquals(30, Solution().minTravelTime(20, 3, 0, position, time))
    }

    @Test
    fun skipSingleMiddlePosition() {
        val position = intArrayOf(0, 10, 20)
        val time = intArrayOf(1, 2, 3)
        assertEquals(20, Solution().minTravelTime(20, 3, 1, position, time))
    }

    @Test
    fun chooseBestMergedSegment() {
        val position = intArrayOf(0, 10, 20, 40)
        val time = intArrayOf(1, 2, 3, 4)
        assertEquals(70, Solution().minTravelTime(40, 4, 1, position, time))
    }

    @Test
    fun singlePosition() {
        assertEquals(0, Solution().minTravelTime(0, 1, 0, intArrayOf(0), intArrayOf(5)))
    }
}
