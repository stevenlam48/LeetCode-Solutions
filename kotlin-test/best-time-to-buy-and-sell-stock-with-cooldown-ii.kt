package besttimetobuyandsellstockwithcooldownii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockWithCooldownIiTest {
    @Test
    fun noCooldownNoCosts() {
        assertEquals(2, Solution().maxProfit(intArrayOf(1, 2, 3), 0, intArrayOf(0, 0, 0)))
    }

    @Test
    fun cooldownAllowsBothTrades() {
        assertEquals(2, Solution().maxProfit(intArrayOf(1, 2, 3), 1, intArrayOf(0, 0, 0)))
    }

    @Test
    fun costsMakeTradesUnprofitable() {
        assertEquals(0, Solution().maxProfit(intArrayOf(1, 2, 3), 1, intArrayOf(0, 2, 2)))
    }

    @Test
    fun bestSingleTrade() {
        assertEquals(2, Solution().maxProfit(intArrayOf(5, 1, 3), 0, intArrayOf(0, 0, 0)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().maxProfit(intArrayOf(), 0, intArrayOf()))
    }

    @Test
    fun singlePrice() {
        assertEquals(0, Solution().maxProfit(intArrayOf(7), 2, intArrayOf(0)))
    }
}
