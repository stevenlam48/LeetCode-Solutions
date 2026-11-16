package maximumcapacitywithinbudget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumCapacityWithinBudgetTest {
    @Test
    fun example() {
        assertEquals(40, Solution().maxCapacity(intArrayOf(1, 2, 3), intArrayOf(10, 20, 30), 5))
    }

    @Test
    fun onlyOneItemFits() {
        assertEquals(6, Solution().maxCapacity(intArrayOf(1, 1), intArrayOf(5, 6), 2))
    }

    @Test
    fun singleItem() {
        assertEquals(7, Solution().maxCapacity(intArrayOf(2), intArrayOf(7), 3))
    }

    @Test
    fun singleCheapItem() {
        assertEquals(5, Solution().maxCapacity(intArrayOf(1), intArrayOf(5), 3))
    }

    @Test
    fun bestPair() {
        assertEquals(11, Solution().maxCapacity(intArrayOf(1, 2, 1), intArrayOf(4, 7, 3), 4))
    }
}
