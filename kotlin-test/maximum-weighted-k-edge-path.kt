package maximumweightedkedgepath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumWeightedKEdgePathTest {
    private val solution = Solution()

    @Test
    fun twoEdgesUnderLimit() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1))
        assertEquals(2, solution.maxWeight(3, edges, 2, 3))
    }

    @Test
    fun twoEdgesReachTheLimitExactly() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 2))
        assertEquals(-1, solution.maxWeight(3, edges, 2, 4))
    }

    @Test
    fun singleEdge() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertEquals(1, solution.maxWeight(2, edges, 1, 2))
    }

    @Test
    fun singleEdgeTooHeavy() {
        val edges = arrayOf(intArrayOf(0, 1, 5))
        assertEquals(-1, solution.maxWeight(2, edges, 1, 5))
    }

    @Test
    fun zeroEdgesPathHasWeightZero() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertEquals(0, solution.maxWeight(2, edges, 0, 1))
    }
}
