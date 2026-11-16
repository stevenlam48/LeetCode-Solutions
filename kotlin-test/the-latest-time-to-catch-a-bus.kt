package thelatesttimetocatchabus

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheLatestTimeToCatchABusTest {

    @Test
    fun testExample1() {
        assertEquals(16, Solution().latestTimeCatchTheBus(intArrayOf(10, 20), intArrayOf(2, 17, 18, 19), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(20, Solution().latestTimeCatchTheBus(intArrayOf(20, 30, 10), intArrayOf(19, 13, 26, 4, 25, 11, 21), 2))
    }

    @Test
    fun testSingleBusWithRoom() {
        assertEquals(3, Solution().latestTimeCatchTheBus(intArrayOf(3), intArrayOf(2, 4), 2))
    }

    @Test
    fun testPassengerAtBusTime() {
        assertEquals(1, Solution().latestTimeCatchTheBus(intArrayOf(2), intArrayOf(2), 2))
    }

    @Test
    fun testFullBus() {
        assertEquals(1, Solution().latestTimeCatchTheBus(intArrayOf(5), intArrayOf(2, 3), 2))
    }

    @Test
    fun testConsecutivePassengers() {
        assertEquals(4, Solution().latestTimeCatchTheBus(intArrayOf(10), intArrayOf(5, 6, 7), 3))
    }
}
