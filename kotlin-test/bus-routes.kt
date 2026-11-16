package busroutes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BusRoutesTest {
    @Test
    fun oneTransfer() {
        val routes = arrayOf(intArrayOf(1, 2, 7), intArrayOf(3, 6, 7))
        assertEquals(2, Solution().numBusesToDestination(routes, 1, 6))
    }

    @Test
    fun unreachableDestination() {
        val routes = arrayOf(intArrayOf(7, 12), intArrayOf(4, 5, 15), intArrayOf(6), intArrayOf(15, 19), intArrayOf(9, 12, 13))
        assertEquals(-1, Solution().numBusesToDestination(routes, 15, 12))
    }

    @Test
    fun directRoute() {
        assertEquals(1, Solution().numBusesToDestination(arrayOf(intArrayOf(1, 2, 3)), 1, 3))
    }

    @Test
    fun sourceEqualsTarget() {
        assertEquals(0, Solution().numBusesToDestination(arrayOf(), 5, 5))
    }
}
