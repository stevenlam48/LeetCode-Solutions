package minimumdistanceexcludingonemaximumweightededge
// Time:  O(n + elogn)
// Space: O(n + e)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceExcludingOneMaximumWeightedEdgeTest {
    private val solution = Solution()

    @Test
    fun excludeOneEdgeFromEachCandidatePath() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(1, 3, 5),
            intArrayOf(0, 2, 1),
            intArrayOf(2, 3, 1)
        )
        assertEquals(1L, solution.minCostExcludingMax(4, edges))
    }

    @Test
    fun twoEdgePathBecomesSingleCost() {
        val edges = arrayOf(intArrayOf(0, 1, 4), intArrayOf(1, 2, 7))
        assertEquals(4L, solution.minCostExcludingMax(3, edges))
    }

    @Test
    fun directEdgeCanBeExcluded() {
        val edges = arrayOf(intArrayOf(0, 1, 10))
        assertEquals(0L, solution.minCostExcludingMax(2, edges))
    }

    @Test
    fun disconnectedGraphKeepsInfiniteDistance() {
        assertEquals(Long.MAX_VALUE, solution.minCostExcludingMax(3, arrayOf(intArrayOf(0, 1, 2))))
    }
}
