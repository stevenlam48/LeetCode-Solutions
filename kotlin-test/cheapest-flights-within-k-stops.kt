package cheapestflightswithinkstops

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheapestFlightsWithinKStopsTest {
    private val solution = Solution()

    private val flights = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(2, 0, 100),
        intArrayOf(1, 3, 600),
        intArrayOf(2, 3, 200)
    )

    @Test
    fun exampleWithinOneStop() {
        assertEquals(700, solution.findCheapestPrice(4, flights, 0, 3, 1))
    }

    @Test
    fun directFlightRequired() {
        assertEquals(-1, solution.findCheapestPrice(4, flights, 0, 3, 0))
    }

    @Test
    fun sourceIsDestination() {
        assertEquals(0, solution.findCheapestPrice(2, emptyArray(), 1, 1, 0))
    }

    @Test
    fun cheaperIndirectRoute() {
        val routes = arrayOf(
            intArrayOf(0, 2, 10),
            intArrayOf(2, 3, 10),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 3, 100)
        )
        assertEquals(20, solution.findCheapestPrice(4, routes, 0, 3, 1))
    }

    @Test
    fun unreachableDestination() {
        assertEquals(-1, solution.findCheapestPrice(3, emptyArray(), 0, 2, 2))
    }
}
