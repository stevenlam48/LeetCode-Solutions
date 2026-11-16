package besttimetobuyandsellstockv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockVTest {
    @Test
    fun example1() {
        assertEquals(14L, Solution().maximumProfit(intArrayOf(1, 7, 9, 8, 2), 2))
    }

    @Test
    fun singleTransaction() {
        assertEquals(8L, Solution().maximumProfit(intArrayOf(1, 7, 9, 8, 2), 1))
    }

    @Test
    fun shortSelling() {
        assertEquals(2L, Solution().maximumProfit(intArrayOf(5, 4, 3), 1))
    }

    @Test
    fun singlePrice() {
        assertEquals(0L, Solution().maximumProfit(intArrayOf(1), 1))
    }

    @Test
    fun increasingPrices() {
        assertEquals(4L, Solution().maximumProfit(intArrayOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun zeroTransactions() {
        assertEquals(0L, Solution().maximumProfit(intArrayOf(1, 5, 2), 0))
    }
}
