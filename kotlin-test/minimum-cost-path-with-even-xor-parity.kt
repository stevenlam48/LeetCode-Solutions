package minimumcostpathwithevenxorparity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostPathWithEvenXorParityTest {
    @Test
    fun edgeBetweenSameParityNodes() {
        assertEquals(5, Solution().minActivationCost(arrayOf(intArrayOf(0, 1, 5)), intArrayOf(1, 1)))
        assertEquals(5, Solution().minActivationCost(arrayOf(intArrayOf(0, 1, 5)), intArrayOf(3, 5)))
    }

    @Test
    fun singleEdgeBetweenDifferentParityNodes() {
        assertEquals(-1, Solution().minActivationCost(arrayOf(intArrayOf(0, 1, 5)), intArrayOf(3, 1)))
    }

    @Test
    fun twoEdgesSharingEvenParityNode() {
        assertEquals(11, Solution().minActivationCost(
            arrayOf(intArrayOf(0, 1, 4), intArrayOf(0, 2, 7)), intArrayOf(3, 1, 2)
        ))
    }

    @Test
    fun cheapestSameParityEdgeWins() {
        assertEquals(3, Solution().minActivationCost(
            arrayOf(intArrayOf(0, 1, 4), intArrayOf(1, 2, 3)), intArrayOf(3, 5, 6)
        ))
    }

    @Test
    fun noEdges() {
        assertEquals(-1, Solution().minActivationCost(arrayOf(), intArrayOf(1, 2)))
    }
}
