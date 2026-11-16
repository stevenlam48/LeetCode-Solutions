package minimumcostwalkinweightedgraph

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumCostWalkInWeightedGraphTest {
    @Test
    fun example1() {
        val edges = arrayOf(intArrayOf(0, 1, 7), intArrayOf(1, 3, 7), intArrayOf(1, 2, 1))
        val query = arrayOf(intArrayOf(0, 3), intArrayOf(3, 4))
        assertArrayEquals(intArrayOf(1, -1), Solution().minimumCost(5, edges, query))
    }

    @Test
    fun simple() {
        val edges = arrayOf(intArrayOf(0, 1, 5))
        val query = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 1))
        assertArrayEquals(intArrayOf(5, -1, 0), Solution().minimumCost(3, edges, query))
    }

    @Test
    fun noEdges() {
        val query = arrayOf(intArrayOf(0, 1), intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(-1, 0), Solution().minimumCost(2, emptyArray(), query))
    }

    @Test
    fun chain() {
        val edges = arrayOf(intArrayOf(0, 1, 3), intArrayOf(1, 2, 5), intArrayOf(2, 3, 7))
        val query = arrayOf(intArrayOf(0, 3))
        assertArrayEquals(intArrayOf(1), Solution().minimumCost(4, edges, query))
    }

    @Test
    fun cycle() {
        val edges = arrayOf(intArrayOf(0, 1, 6), intArrayOf(1, 2, 3), intArrayOf(0, 2, 5))
        val query = arrayOf(intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(0), Solution().minimumCost(3, edges, query))
    }
}
