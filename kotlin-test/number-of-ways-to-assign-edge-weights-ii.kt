package numberofwaystoassignedgeweightsii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToAssignEdgeWeightsIITest {
    @Test
    fun example1() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4))
        val queries = arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(3, 4), intArrayOf(2, 2), intArrayOf(1, 1))
        assertArrayEquals(intArrayOf(1, 2, 4, 0, 0), Solution().assignEdgeWeights(edges, queries))
    }

    @Test
    fun pathTree() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5))
        val queries = arrayOf(intArrayOf(1, 5), intArrayOf(2, 4), intArrayOf(1, 1), intArrayOf(3, 5))
        assertArrayEquals(intArrayOf(8, 2, 0, 2), Solution().assignEdgeWeights(edges, queries))
    }

    @Test
    fun adjacentNodes() {
        val edges = arrayOf(intArrayOf(1, 2))
        val queries = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1))
        assertArrayEquals(intArrayOf(1, 1), Solution().assignEdgeWeights(edges, queries))
    }
}
