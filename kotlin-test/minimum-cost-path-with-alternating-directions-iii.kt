package minimumcostpathwithalternatingdirectionsiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostPathWithAlternatingDirectionsIIITest {
    @Test
    fun singleCell() {
        assertEquals(1L, Solution().minCost(1, 1, arrayOf(intArrayOf(0))))
    }

    @Test
    fun singleRow() {
        assertEquals(3L, Solution().minCost(1, 2, arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun twoByTwoWithoutPenalty() {
        assertEquals(7L, Solution().minCost(2, 2, arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun twoByTwoWithPenalty() {
        assertEquals(17L, Solution().minCost(2, 2, arrayOf(intArrayOf(10, 10), intArrayOf(10, 10))))
    }
}
