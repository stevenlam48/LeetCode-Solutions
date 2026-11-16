package minimumcostpathwithalternatingdirectionsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostPathWithAlternatingDirectionsIITest {
    @Test
    fun singleRowTwoColumns() {
        assertEquals(3L, Solution().minCost(1, 2, arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun twoByTwo() {
        assertEquals(9L, Solution().minCost(2, 2, arrayOf(intArrayOf(3, 2), intArrayOf(4, 5))))
    }

    @Test
    fun singleCell() {
        assertEquals(1L, Solution().minCost(1, 1, arrayOf(intArrayOf(7))))
    }

    @Test
    fun twoByThree() {
        assertEquals(17L, Solution().minCost(2, 3, arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))))
    }
}
