package maximumprofitfromtradingstockswithdiscounts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProfitFromTradingStocksWithDiscountsTest {
    @Test
    fun example1() {
        assertEquals(
            5,
            Solution().maxProfit(2, intArrayOf(1, 2), intArrayOf(4, 3), arrayOf(intArrayOf(1, 2)), 2)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            8,
            Solution().maxProfit(2, intArrayOf(3, 4), intArrayOf(5, 8), arrayOf(intArrayOf(1, 2)), 8)
        )
    }

    @Test
    fun singleNodeAffordable() {
        assertEquals(5, Solution().maxProfit(1, intArrayOf(5), intArrayOf(10), emptyArray(), 5))
    }

    @Test
    fun singleNodeTooExpensive() {
        assertEquals(0, Solution().maxProfit(1, intArrayOf(5), intArrayOf(10), emptyArray(), 4))
    }

    @Test
    fun childWithoutParent() {
        assertEquals(
            4,
            Solution().maxProfit(2, intArrayOf(10, 1), intArrayOf(20, 5), arrayOf(intArrayOf(1, 2)), 5)
        )
    }
}
