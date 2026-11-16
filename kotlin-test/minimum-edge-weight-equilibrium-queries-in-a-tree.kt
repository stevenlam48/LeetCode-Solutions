package minimumedgeweightequilibriumqueriesinatree

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumEdgeWeightEquilibriumQueriesInATreeTest {
    @Test
    fun exampleSevenNodes() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 1),
            intArrayOf(3, 4, 2),
            intArrayOf(4, 5, 1),
            intArrayOf(5, 6, 2)
        )
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(3, 6), intArrayOf(6, 3))
        assertArrayEquals(intArrayOf(0, 1, 1), Solution().minOperationsQueries(7, edges, queries))
    }

    @Test
    fun singleEdgeNeedsNoChange() {
        val edges = arrayOf(intArrayOf(0, 1, 5))
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        assertArrayEquals(intArrayOf(0, 0), Solution().minOperationsQueries(2, edges, queries))
    }

    @Test
    fun mixedWeightsOnChain() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 2))
        val queries = arrayOf(intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(1), Solution().minOperationsQueries(3, edges, queries))
    }

    @Test
    fun queryToItself() {
        val edges = arrayOf(intArrayOf(0, 1, 3))
        val queries = arrayOf(intArrayOf(1, 1))
        assertArrayEquals(intArrayOf(0), Solution().minOperationsQueries(2, edges, queries))
    }
}
