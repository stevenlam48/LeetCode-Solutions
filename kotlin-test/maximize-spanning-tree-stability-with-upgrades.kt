package maximizespanningtreestabilitywithupgrades

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MaximizeSpanningTreeStabilityWithUpgradesTest {
    @Test
    fun upgradesOneOptionalEdge() {
        val edges = arrayOf(
            intArrayOf(0, 1, 10, 1),
            intArrayOf(1, 2, 4, 0),
            intArrayOf(0, 2, 3, 0)
        )
        assertEquals(8, Solution().maxStability(3, edges, 1))
    }

    @Test
    fun noUpgradesAvailable() {
        val edges = arrayOf(
            intArrayOf(0, 1, 10, 1),
            intArrayOf(1, 2, 4, 0),
            intArrayOf(0, 2, 3, 0)
        )
        assertEquals(4, Solution().maxStability(3, edges, 0))
    }

    @Test
    fun upgradesAllOptionalEdges() {
        val edges = arrayOf(
            intArrayOf(0, 1, 9, 1),
            intArrayOf(1, 2, 8, 0),
            intArrayOf(2, 3, 7, 0),
            intArrayOf(0, 3, 6, 0)
        )
        assertEquals(9, Solution().maxStability(4, edges, 2))
    }

    @Test
    fun mandatoryCycleIsInvalid() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 1),
            intArrayOf(1, 0, 4, 1)
        )
        assertEquals(-1, Solution().maxStability(2, edges, 0))
    }

    @Test
    fun disconnectedGraphIsInvalid() {
        val edges = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(1, 2, 3, 0)
        )
        assertEquals(-1, Solution().maxStability(4, edges, 1))
    }
}
