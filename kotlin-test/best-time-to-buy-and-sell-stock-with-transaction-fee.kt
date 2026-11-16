package besttimetobuyandsellstockwithtransactionfee

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockWithTransactionFeeTest {
    @Test
    fun example1() {
        assertEquals(8, Solution().maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().maxProfit(intArrayOf(1, 3, 7, 5, 10, 3), 3))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxProfit(intArrayOf(1), 1))
    }

    @Test
    fun feeCancelsSmallGain() {
        assertEquals(0, Solution().maxProfit(intArrayOf(1, 2), 1))
    }

    @Test
    fun decreasingPrices() {
        assertEquals(0, Solution().maxProfit(intArrayOf(5, 4, 3, 2, 1), 1))
    }
}
