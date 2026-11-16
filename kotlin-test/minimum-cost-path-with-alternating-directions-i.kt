package minimumcostpathwithalternatingdirectionsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostPathWithAlternatingDirectionsITest {
    @Test
    fun singleCell() {
        assertEquals(1, Solution().minCost(1, 1))
    }

    @Test
    fun oneByTwoGrids() {
        assertEquals(3, Solution().minCost(1, 2))
        assertEquals(3, Solution().minCost(2, 1))
    }

    @Test
    fun largerGrids() {
        assertEquals(-1, Solution().minCost(2, 2))
        assertEquals(-1, Solution().minCost(1, 3))
        assertEquals(-1, Solution().minCost(3, 1))
    }
}
