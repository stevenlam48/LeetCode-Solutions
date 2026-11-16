package criticalconnectionsinanetwork

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CriticalConnectionsInANetworkTest {
    @Test
    fun `finds the only bridge outside a cycle`() {
        val connections = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0), intArrayOf(1, 3)
        )
        assertEquals(listOf(listOf(1, 3)), asLists(Solution().criticalConnections(4, connections)))
    }

    @Test
    fun `a single connection is critical`() {
        val connections = arrayOf(intArrayOf(0, 1))
        assertEquals(listOf(listOf(0, 1)), asLists(Solution().criticalConnections(2, connections)))
    }

    @Test
    fun `every edge in a chain is critical`() {
        val connections = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(listOf(listOf(1, 2), listOf(0, 1)), asLists(Solution().criticalConnections(3, connections)))
    }

    @Test
    fun `a cycle has no critical connections`() {
        val connections = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0))
        assertEquals(emptyList<List<Int>>(), asLists(Solution().criticalConnections(3, connections)))
    }
}

private fun asLists(connections: Array<IntArray>): List<List<Int>> {
    return connections.map { it.toList() }
}
