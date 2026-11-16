package minimumcosttorepairedgestotraverseagraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToRepairEdgesToTraverseAGraphTest {
    private val chain = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(1, 2, 3),
        intArrayOf(2, 3, 1)
    )

    @Test
    fun chainK3() {
        assertEquals(3, Solution().minCost(4, chain, 3))
    }

    @Test
    fun chainK2() {
        assertEquals(-1, Solution().minCost(4, chain, 2))
    }

    @Test
    fun singleEdge() {
        assertEquals(5, Solution().minCost(2, arrayOf(intArrayOf(0, 1, 5)), 1))
    }

    @Test
    fun directCheapEdge() {
        val edges = arrayOf(intArrayOf(0, 1, 10), intArrayOf(1, 2, 10), intArrayOf(0, 2, 1))
        assertEquals(1, Solution().minCost(3, edges, 1))
    }

    @Test
    fun directCheapEdgeK2() {
        val edges = arrayOf(intArrayOf(0, 1, 10), intArrayOf(1, 2, 10), intArrayOf(0, 2, 1))
        assertEquals(1, Solution().minCost(3, edges, 2))
    }

    @Test
    fun chainWithExpensiveDirect() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 1),
            intArrayOf(0, 3, 100)
        )
        assertEquals(1, Solution().minCost(4, edges, 3))
    }
}
