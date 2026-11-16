package besttimetobuyandsellstockwithcooldown

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockWithCooldownTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maxProfit(intArrayOf(1, 2, 3, 0, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxProfit(intArrayOf(1)))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().maxProfit(intArrayOf(1, 2)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().maxProfit(intArrayOf()))
    }

    @Test
    fun cooldownForcesGap() {
        assertEquals(3, Solution().maxProfit(intArrayOf(2, 1, 4)))
    }
}
