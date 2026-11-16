package closestdessertcost

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClosestDessertCostTest {
    @Test
    fun findsCostInFirstLeetCodeExample() {
        assertEquals(9, Solution().closestCost(intArrayOf(1, 7), intArrayOf(3, 2), 9))
    }

    @Test
    fun findsCostInSecondLeetCodeExample() {
        assertEquals(17, Solution().closestCost(intArrayOf(2, 3), intArrayOf(4, 5, 100), 18))
    }

    @Test
    fun prefersLowerCostWhenDistancesTie() {
        assertEquals(8, Solution().closestCost(intArrayOf(3, 10), intArrayOf(2, 5), 9))
    }

    @Test
    fun returnsBaseWhenEveryCostIsAboveTarget() {
        assertEquals(10, Solution().closestCost(intArrayOf(10), intArrayOf(1), 1))
    }

    @Test
    fun allowsEachToppingToBeUsedTwice() {
        assertEquals(11, Solution().closestCost(intArrayOf(1), intArrayOf(5), 11))
    }
}
