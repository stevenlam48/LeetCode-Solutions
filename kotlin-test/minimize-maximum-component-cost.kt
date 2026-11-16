package minimizemaximumcomponentcost
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeMaximumComponentCostTest {
    @Test
    fun example() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 3, 2),
            intArrayOf(3, 4, 6)
        )
        assertEquals(4, Solution().minCost(5, edges, 2))
    }

    @Test
    fun noMergesNeeded() {
        val edges = arrayOf(intArrayOf(0, 1, 7), intArrayOf(1, 2, 9))
        assertEquals(0, Solution().minCost(3, edges, 3))
    }

    @Test
    fun cycleEdgesAreIgnored() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 2, 3),
            intArrayOf(2, 3, 4)
        )
        assertEquals(1, Solution().minCost(4, edges, 3))
    }

    @Test
    fun disconnectedGraph() {
        val edges = arrayOf(intArrayOf(0, 1, 2))
        assertEquals(0, Solution().minCost(4, edges, 2))
    }

    @Test
    fun oneComponent() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(0, 2, 10)
        )
        assertEquals(2, Solution().minCost(3, edges, 1))
    }
}
