package findcriticalandpseudocriticaledgesinminimumspanningtree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTreeTest {
    private fun asLists(result: Array<IntArray>): List<List<Int>> = result.map { it.toList() }

    @Test
    fun standardExample() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 2),
            intArrayOf(0, 3, 2),
            intArrayOf(0, 4, 3),
            intArrayOf(3, 4, 3),
            intArrayOf(1, 4, 6)
        )
        assertEquals(
            listOf(listOf(0, 1), listOf(2, 3, 4, 5)),
            asLists(Solution().findCriticalAndPseudoCriticalEdges(5, edges))
        )
    }

    @Test
    fun allEdgesPseudoCriticalInCycle() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 1),
            intArrayOf(0, 3, 1)
        )
        assertEquals(
            listOf(emptyList<Int>(), listOf(0, 1, 2, 3)),
            asLists(Solution().findCriticalAndPseudoCriticalEdges(4, edges))
        )
    }

    @Test
    fun treeEdgesAreAllCritical() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1)
        )
        assertEquals(
            listOf(listOf(0, 1), emptyList<Int>()),
            asLists(Solution().findCriticalAndPseudoCriticalEdges(3, edges))
        )
    }

    @Test
    fun heavierEdgeIsNeither() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 2, 5)
        )
        assertEquals(
            listOf(listOf(0, 1), emptyList<Int>()),
            asLists(Solution().findCriticalAndPseudoCriticalEdges(3, edges))
        )
    }
}
