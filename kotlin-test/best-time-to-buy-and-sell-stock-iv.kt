package besttimetobuyandsellstockiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockIvTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxProfit(2, intArrayOf(2, 4, 1)))
    }

    @Test
    fun example2() {
        assertEquals(7, Solution().maxProfit(2, intArrayOf(3, 2, 6, 5, 0, 3)))
    }

    @Test
    fun example3() {
        assertEquals(13, Solution().maxProfit(2, intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0)))
    }

    @Test
    fun singleTransaction() {
        assertEquals(1, Solution().maxProfit(1, intArrayOf(1, 2)))
    }

    @Test
    fun singlePrice() {
        assertEquals(0, Solution().maxProfit(2, intArrayOf(1)))
    }

    @Test
    fun kExceedsAvailableTransactions() {
        assertEquals(4, Solution().maxProfit(100, intArrayOf(1, 2, 3, 4, 5)))
    }
}
