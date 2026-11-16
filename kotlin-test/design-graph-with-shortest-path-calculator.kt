package designgraphwithshortestpathcalculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignGraphWithShortestPathCalculatorTest {
    @Test
    fun leetCodeExample() {
        val graph = Graph(4, arrayOf(intArrayOf(0, 2, 5), intArrayOf(0, 1, 2), intArrayOf(1, 2, 1), intArrayOf(3, 0, 3)))
        assertEquals(6, graph.shortestPath(3, 2))
        assertEquals(-1, graph.shortestPath(0, 3))
        graph.addEdge(intArrayOf(1, 3, 4))
        assertEquals(6, graph.shortestPath(0, 3))
    }

    @Test
    fun sameSourceAndTarget() {
        val graph = Graph(1, emptyArray())
        assertEquals(0, graph.shortestPath(0, 0))
    }

    @Test
    fun directEdgeMayNotBeShortest() {
        val graph = Graph(3, arrayOf(intArrayOf(0, 2, 20), intArrayOf(0, 1, 3), intArrayOf(1, 2, 4)))
        assertEquals(7, graph.shortestPath(0, 2))
        graph.addEdge(intArrayOf(0, 2, 6))
        assertEquals(6, graph.shortestPath(0, 2))
    }

    @Test
    fun disconnectedAndParallelEdges() {
        val graph = Graph(4, arrayOf(intArrayOf(0, 1, 8), intArrayOf(0, 1, 2), intArrayOf(2, 3, 1)))
        assertEquals(2, graph.shortestPath(0, 1))
        assertEquals(-1, graph.shortestPath(1, 3))
        assertEquals(1, graph.shortestPath(2, 3))
    }
}
