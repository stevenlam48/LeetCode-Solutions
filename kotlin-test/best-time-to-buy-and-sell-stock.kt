package besttimetobuyandsellstock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockTest {
    @Test
    fun example() {
        assertEquals(5, Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    @Test
    fun decreasingPrices() {
        assertEquals(0, Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    @Test
    fun emptyPrices() {
        assertEquals(0, Solution().maxProfit(intArrayOf()))
    }

    @Test
    fun singlePrice() {
        assertEquals(0, Solution().maxProfit(intArrayOf(1)))
    }

    @Test
    fun laterRiseAfterLowerValley() {
        assertEquals(4, Solution().maxProfit(intArrayOf(3, 2, 6, 1, 5)))
    }
}
