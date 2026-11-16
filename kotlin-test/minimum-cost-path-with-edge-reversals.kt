package minimumcostpathwithedgereversals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostPathWithEdgeReversalsTest {
    @Test
    fun linearPath() {
        assertEquals(9, Solution().minCost(
            4, arrayOf(intArrayOf(0, 1, 5), intArrayOf(1, 2, 3), intArrayOf(2, 3, 1))
        ))
    }

    @Test
    fun singleForwardEdge() {
        assertEquals(7, Solution().minCost(2, arrayOf(intArrayOf(0, 1, 7))))
    }

    @Test
    fun singleReversedEdge() {
        assertEquals(4, Solution().minCost(2, arrayOf(intArrayOf(1, 0, 2))))
    }

    @Test
    fun mustReverseThenGoForward() {
        assertEquals(6, Solution().minCost(
            3, arrayOf(intArrayOf(1, 0, 2), intArrayOf(1, 2, 2))
        ))
    }

    @Test
    fun alreadyAtTarget() {
        assertEquals(0, Solution().minCost(1, arrayOf()))
    }
}
