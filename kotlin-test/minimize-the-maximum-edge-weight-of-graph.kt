package minimizethemaximumedgeweightofgraph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimizeTheMaximumEdgeWeightOfGraphTest {
    private val solution = Solution()

    @Test
    fun traversesReversedCycleFromZero() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 1),
            intArrayOf(3, 4, 1),
            intArrayOf(4, 0, 2)
        )
        assertEquals(2, solution.minMaxWeight(5, edges, 1))
    }

    @Test
    fun selectsPathsThatMinimizeTheLargestEdge() {
        val edges = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(2, 0, 2),
            intArrayOf(3, 0, 1),
            intArrayOf(2, 1, 1),
            intArrayOf(3, 1, 3),
            intArrayOf(3, 2, 4)
        )
        assertEquals(1, solution.minMaxWeight(4, edges, 3))
    }

    @Test
    fun usesLightestOfDuplicateEdges() {
        val edges = arrayOf(
            intArrayOf(1, 0, 5),
            intArrayOf(1, 0, 2),
            intArrayOf(2, 1, 4),
            intArrayOf(2, 0, 6)
        )
        assertEquals(4, solution.minMaxWeight(3, edges, 1))
    }

    @Test
    fun returnsMinusOneWhenGraphIsUnreachable() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertEquals(-1, solution.minMaxWeight(3, edges, 1))
    }

    @Test
    fun handlesSingleNodeWithoutEdges() {
        assertEquals(0, solution.minMaxWeight(1, emptyArray(), 0))
    }
}
