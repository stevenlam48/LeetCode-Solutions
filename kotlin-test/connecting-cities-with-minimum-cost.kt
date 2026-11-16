package connectingcitieswithminimumcost

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConnectingCitiesWithMinimumCostTest {
    @Test
    fun buildsMinimumSpanningTree() {
        val connections = arrayOf(intArrayOf(1, 2, 5), intArrayOf(1, 3, 6), intArrayOf(2, 3, 1))
        assertEquals(6, Solution().minimumCost(3, connections))
    }

    @Test
    fun returnsMinusOneForDisconnectedGraph() {
        val connections = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 4, 4))
        assertEquals(-1, Solution().minimumCost(4, connections))
    }

    @Test
    fun ignoresMoreExpensiveCycleEdges() {
        val connections = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 4, 4),
            intArrayOf(1, 3, 2),
            intArrayOf(2, 4, 5),
            intArrayOf(2, 3, 1),
        )
        assertEquals(7, Solution().minimumCost(4, connections))
    }

    @Test
    fun singleCityNeedsNoConnections() {
        assertEquals(0, Solution().minimumCost(1, emptyArray()))
    }
}
