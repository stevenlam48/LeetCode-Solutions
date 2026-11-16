package shortestpathinaweightedtree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathInAWeightedTreeTest {
    @Test
    fun answersDistanceQueries() {
        val edges = arrayOf(intArrayOf(1, 2, 7))
        val queries = arrayOf(intArrayOf(2, 2), intArrayOf(1, 1, 2, 5), intArrayOf(2, 2))
        assertArrayEquals(intArrayOf(7, 5), Solution().treeQueries(2, edges, queries))
    }

    @Test
    fun answersTwoLeafQueries() {
        val edges = arrayOf(intArrayOf(1, 2, 2), intArrayOf(1, 3, 3))
        val queries = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(2, 3),
            intArrayOf(1, 1, 2, 10),
            intArrayOf(2, 2)
        )
        assertArrayEquals(intArrayOf(2, 3, 10), Solution().treeQueries(3, edges, queries))
    }

    @Test
    fun updatesPropagateToTheWholeSubtree() {
        val edges = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 1),
            intArrayOf(2, 4, 1)
        )
        val queries = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(1, 2, 3, 5),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
            intArrayOf(1, 1, 2, 10),
            intArrayOf(2, 3),
            intArrayOf(2, 4)
        )
        assertArrayEquals(intArrayOf(2, 6, 2, 15, 11), Solution().treeQueries(4, edges, queries))
    }

    @Test
    fun handlesUpdateGivenInReverseOrder() {
        val edges = arrayOf(intArrayOf(1, 2, 4), intArrayOf(2, 3, 5))
        val queries = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(1, 3, 2, 2),
            intArrayOf(2, 3),
            intArrayOf(2, 2)
        )
        assertArrayEquals(intArrayOf(9, 6, 4), Solution().treeQueries(3, edges, queries))
    }

    @Test
    fun handlesSingleNode() {
        val queries = arrayOf(intArrayOf(2, 1))
        assertArrayEquals(intArrayOf(0), Solution().treeQueries(1, emptyArray(), queries))
    }
}
