package cloneGraph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CloneGraphTest {
    @Test
    fun returnsNullForNullGraph() {
        assertNull(Solution().cloneGraph(null))
    }

    @Test
    fun clonesSingleNodeWithoutNeighbors() {
        val original = UndirectedGraphNode(7)
        val cloned = Solution().cloneGraph(original)!!

        assertNotSame(original, cloned)
        assertEquals(7, cloned.label)
        assertTrue(cloned.neighbors.isEmpty())
    }

    @Test
    fun clonesFourNodeCycle() {
        val nodes = graphOf(listOf(listOf(2, 4), listOf(1, 3), listOf(2, 4), listOf(1, 3)))
        val cloned = Solution().cloneGraph(nodes[0])!!

        assertNotSame(nodes[0], cloned)
        assertEquals(listOf(2, 4), cloned.neighbors.map { it.label })
        assertEquals(listOf(1, 3), cloned.neighbors[0].neighbors.map { it.label })
        assertEquals(listOf(2, 4), cloned.neighbors[0].neighbors[1].neighbors.map { it.label })
        assertSame(cloned, cloned.neighbors[0].neighbors[0])
        assertSame(cloned.neighbors[1], cloned.neighbors[0].neighbors[1].neighbors[1])
    }

    @Test
    fun clonesSharedNeighborsWithoutDuplicatingNodes() {
        val nodes = graphOf(listOf(listOf(2, 3), listOf(1, 3), listOf(1, 2)))
        val cloned = Solution().cloneGraph(nodes[0])!!
        val second = cloned.neighbors.single { it.label == 2 }
        val third = cloned.neighbors.single { it.label == 3 }

        assertEquals(listOf(1, 3), second.neighbors.map { it.label })
        assertEquals(listOf(1, 2), third.neighbors.map { it.label })
        assertSame(cloned, second.neighbors.single { it.label == 1 })
        assertSame(cloned, third.neighbors.single { it.label == 1 })
        assertSame(third, second.neighbors.single { it.label == 3 })
        assertSame(second, third.neighbors.single { it.label == 2 })
        nodes.forEach { original -> assertTrue(original !== cloned && cloned.neighbors.all { original !== it }) }
    }
}

private fun graphOf(adjacency: List<List<Int>>): List<UndirectedGraphNode> {
    val nodes = adjacency.indices.map { UndirectedGraphNode(it + 1) }
    for (i in adjacency.indices) {
        for (neighbor in adjacency[i]) {
            nodes[i].neighbors.add(nodes[neighbor - 1])
        }
    }
    return nodes
}
