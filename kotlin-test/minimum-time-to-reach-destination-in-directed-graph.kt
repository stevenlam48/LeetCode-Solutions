package minimumtimetoreachdestinationindirectedgraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToReachDestinationInDirectedGraphTest {
    @Test
    fun directEdgeIsFastest() {
        val edges = arrayOf(intArrayOf(0, 1, 1, 3), intArrayOf(1, 2, 2, 5), intArrayOf(0, 2, 0, 10))
        assertEquals(1, Solution().minTime(3, edges))
    }

    @Test
    fun waitsForEdgeToOpen() {
        val edges = arrayOf(intArrayOf(0, 1, 3, 5))
        assertEquals(4, Solution().minTime(2, edges))
    }

    @Test
    fun edgeClosesBeforeArrival() {
        val edges = arrayOf(intArrayOf(0, 1, 3, 5), intArrayOf(1, 2, 0, 2))
        assertEquals(-1, Solution().minTime(3, edges))
    }

    @Test
    fun destinationUnreachable() {
        assertEquals(-1, Solution().minTime(3, arrayOf(intArrayOf(0, 1, 0, 2))))
    }
}
