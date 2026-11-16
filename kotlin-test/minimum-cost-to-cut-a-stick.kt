package minimumcosttocutastick

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToCutAStickTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(16, solution.minCost(7, intArrayOf(1, 3, 4, 5)))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(22, solution.minCost(9, intArrayOf(5, 6, 1, 4, 2)))
    }

    @Test
    fun noCuts() {
        assertEquals(0, solution.minCost(10, IntArray(0)))
    }

    @Test
    fun singleCutCostsFullStickLength() {
        assertEquals(5, solution.minCost(5, intArrayOf(2)))
    }
}
