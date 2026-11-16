package minimizethemaximumwaitingtimeatsynchronizedtrafficlights

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeTheMaximumWaitingTimeAtSynchronizedTrafficLightsTest {
    @Test
    fun example1() {
        assertEquals(7, Solution().minPenalty(10, intArrayOf(2, 3), intArrayOf(0, 2, 3, 4)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().minPenalty(5, intArrayOf(1), intArrayOf(0, 1, 2, 3, 4)))
    }

    @Test
    fun allBeforeGreen() {
        assertEquals(0, Solution().minPenalty(10, intArrayOf(5), intArrayOf(0, 1, 2)))
    }

    @Test
    fun emptyArrivals() {
        assertEquals(0, Solution().minPenalty(10, intArrayOf(3), intArrayOf()))
    }

    @Test
    fun singleArrival() {
        assertEquals(6, Solution().minPenalty(10, intArrayOf(4), intArrayOf(4)))
    }
}
