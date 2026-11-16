package maximizesumofweightsafteredgeremovals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSumOfWeightsAfterEdgeRemovalsTest {
    @Test
    fun kEqualsTwo() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(1, 3, 1),
            intArrayOf(3, 4, 1)
        )
        assertEquals(3L, Solution().maximizeSumOfWeights(edges, 2))
    }

    @Test
    fun kEqualsOne() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(1, 3, 1),
            intArrayOf(3, 4, 1)
        )
        assertEquals(2L, Solution().maximizeSumOfWeights(edges, 1))
    }

    @Test
    fun singleEdge() {
        assertEquals(5L, Solution().maximizeSumOfWeights(arrayOf(intArrayOf(0, 1, 5)), 1))
    }

    @Test
    fun weightedTree() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(0, 2, 5),
            intArrayOf(1, 3, 3)
        )
        assertEquals(12L, Solution().maximizeSumOfWeights(edges, 2))
    }
}
