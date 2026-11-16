package minimumcosttoreachcitywithdiscounts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToReachCityWithDiscountsTest {
    @Test
    fun singleEdgeNoDiscount() {
        assertEquals(10, Solution().minimumCost(2, arrayOf(intArrayOf(0, 1, 10)), 0))
    }

    @Test
    fun singleEdgeWithDiscount() {
        assertEquals(5, Solution().minimumCost(2, arrayOf(intArrayOf(0, 1, 10)), 1))
    }

    @Test
    fun twoEdgesOneDiscount() {
        val highways = arrayOf(intArrayOf(0, 1, 4), intArrayOf(1, 2, 4))
        assertEquals(6, Solution().minimumCost(3, highways, 1))
    }

    @Test
    fun twoEdgesTwoDiscounts() {
        val highways = arrayOf(intArrayOf(0, 1, 4), intArrayOf(1, 2, 4))
        assertEquals(4, Solution().minimumCost(3, highways, 2))
    }

    @Test
    fun unreachable() {
        assertEquals(-1, Solution().minimumCost(3, arrayOf(intArrayOf(0, 1, 4)), 1))
    }

    @Test
    fun alternativeRoute() {
        val highways = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 2),
            intArrayOf(2, 3, 2),
            intArrayOf(0, 3, 10)
        )
        assertEquals(5, Solution().minimumCost(4, highways, 1))
    }
}
