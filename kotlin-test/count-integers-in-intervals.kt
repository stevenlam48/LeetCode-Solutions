package countintegersinintervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountIntegersInIntervalsTest {
    @Test
    fun followsLeetCodeOperationSequence() {
        val intervals = CountIntervals()
        assertEquals(0, intervals.count())
        intervals.add(2, 3)
        intervals.add(7, 10)
        assertEquals(6, intervals.count())
        intervals.add(5, 8)
        assertEquals(8, intervals.count())
    }

    @Test
    fun mergesOverlappingTouchingAndAdjacentIntervals() {
        val intervals = CountIntervals()
        intervals.add(1, 3)
        intervals.add(5, 7)
        intervals.add(4, 4)
        intervals.add(2, 6)
        assertEquals(7, intervals.count())
    }

    @Test
    fun nestedIntervalDoesNotIncreaseCount() {
        val intervals = CountIntervals()
        intervals.add(1, 10)
        intervals.add(3, 5)
        assertEquals(10, intervals.count())
    }
}
