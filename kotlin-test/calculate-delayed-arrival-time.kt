package calculatedelayedarrivaltime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateDelayedArrivalTimeTest {
    @Test
    fun arrivalWithinSameDay() {
        assertEquals(20, Solution().findDelayedArrivalTime(15, 5))
    }

    @Test
    fun arrivalAtMidnight() {
        assertEquals(0, Solution().findDelayedArrivalTime(13, 11))
    }

    @Test
    fun delayOfAnEntireDay() {
        assertEquals(23, Solution().findDelayedArrivalTime(23, 24))
    }

    @Test
    fun noDelay() {
        assertEquals(7, Solution().findDelayedArrivalTime(7, 0))
    }
}
