package shortestpathvisitingallnodes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathVisitingAllNodesTest {
    @Test
    fun visitsStarGraph() {
        val graph = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(0),
            intArrayOf(0),
            intArrayOf(0)
        )
        assertEquals(4, Solution().shortestPathLength(graph))
    }

    @Test
    fun visitsLargerGraph() {
        val graph = arrayOf(
            intArrayOf(1),
            intArrayOf(0, 2, 4),
            intArrayOf(1, 3, 4),
            intArrayOf(2),
            intArrayOf(1, 2)
        )
        assertEquals(4, Solution().shortestPathLength(graph))
    }

    @Test
    fun visitsTwoConnectedNodes() {
        val graph = arrayOf(intArrayOf(1), intArrayOf(0))
        assertEquals(1, Solution().shortestPathLength(graph))
    }

    @Test
    fun handlesSingleNode() {
        assertEquals(0, Solution().shortestPathLength(arrayOf(intArrayOf())))
    }

    @Test
    fun visitsPathGraph() {
        val graph = arrayOf(
            intArrayOf(1),
            intArrayOf(0, 2),
            intArrayOf(1)
        )
        assertEquals(2, Solution().shortestPathLength(graph))
    }
}
