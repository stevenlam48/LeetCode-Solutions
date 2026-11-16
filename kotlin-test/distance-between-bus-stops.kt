package distancebetweenbusstops

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DistanceBetweenBusStopsTest {
    @Test
    fun testExample1() {
        assertEquals(1, Solution().distanceBetweenBusStops(intArrayOf(1, 2, 3, 4), 0, 1))
    }

    @Test
    fun testExample2() {
        assertEquals(3, Solution().distanceBetweenBusStops(intArrayOf(1, 2, 3, 4), 0, 2))
    }

    @Test
    fun testExample3() {
        assertEquals(4, Solution().distanceBetweenBusStops(intArrayOf(1, 2, 3, 4), 0, 3))
    }

    @Test
    fun testReversedStartDestination() {
        assertEquals(3, Solution().distanceBetweenBusStops(intArrayOf(1, 2, 3, 4), 2, 0))
    }

    @Test
    fun testSameStop() {
        assertEquals(0, Solution().distanceBetweenBusStops(intArrayOf(1, 2, 3), 1, 1))
    }
}
