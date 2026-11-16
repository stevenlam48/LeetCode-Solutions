package maximumsumofedgevaluesinagraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfEdgeValuesInAGraphTest {
    private val solution = Solution()

    @Test
    fun singleEdge() {
        assertEquals(2L, solution.maxScore(2, arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun singleChainOfThree() {
        assertEquals(9L, solution.maxScore(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))))
    }

    @Test
    fun singleCycleOfThree() {
        assertEquals(
            11L,
            solution.maxScore(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0)))
        )
    }

    @Test
    fun twoDisjointEdges() {
        assertEquals(14L, solution.maxScore(4, arrayOf(intArrayOf(0, 1), intArrayOf(2, 3))))
    }

    @Test
    fun twoEdgesAndAnIsolatedVertex() {
        assertEquals(26L, solution.maxScore(5, arrayOf(intArrayOf(0, 1), intArrayOf(2, 3))))
    }

    @Test
    fun singleVertex() {
        assertEquals(0L, solution.maxScore(1, emptyArray()))
    }
}
