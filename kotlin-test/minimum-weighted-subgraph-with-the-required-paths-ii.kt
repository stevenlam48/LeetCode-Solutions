package minimumweightedsubgraphwiththerequiredpathsii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumWeightedSubgraphWithTheRequiredPathsIiTest {
    private val solution = Solution()

    @Test
    fun testLineTree() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))
        val queries = arrayOf(intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(5, 5, 2), solution.minimumWeight(edges, queries))
    }

    @Test
    fun testStarTree() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(0, 2, 1), intArrayOf(0, 3, 1)
        )
        val queries = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3))
        assertArrayEquals(intArrayOf(2, 2, 2), solution.minimumWeight(edges, queries))
    }

    @Test
    fun testRootToLeaf() {
        val edges = arrayOf(intArrayOf(0, 1, 7))
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        assertArrayEquals(intArrayOf(7, 7), solution.minimumWeight(edges, queries))
    }

    @Test
    fun testLargerWeights() {
        val edges = arrayOf(
            intArrayOf(0, 1, 10), intArrayOf(1, 2, 20), intArrayOf(2, 3, 30)
        )
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 3))
        assertArrayEquals(intArrayOf(60, 60), solution.minimumWeight(edges, queries))
    }
}
