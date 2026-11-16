package minimumedgereversalssoeverynodeisreachable
// Time:  O(n)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumEdgeReversalsSoEveryNodeIsReachableTest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        val edges = arrayOf(intArrayOf(2, 0), intArrayOf(2, 1), intArrayOf(1, 3))
        assertArrayEquals(intArrayOf(1, 1, 0, 2), solution.minEdgeReversals(4, edges))
    }

    @Test
    fun directedChain() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(0, 1, 2), solution.minEdgeReversals(3, edges))
    }

    @Test
    fun reversedChain() {
        val edges = arrayOf(intArrayOf(2, 1), intArrayOf(1, 0))
        assertArrayEquals(intArrayOf(2, 1, 0), solution.minEdgeReversals(3, edges))
    }

    @Test
    fun singleNode() {
        assertArrayEquals(intArrayOf(0), solution.minEdgeReversals(1, arrayOf()))
    }
}
