package maximumprofitfromtradingstocks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProfitFromTradingStocksTest {
    @Test
    fun example1() {
        assertEquals(9, Solution().maximumProfit(intArrayOf(5, 2, 3), intArrayOf(8, 5, 6), 10))
    }

    @Test
    fun unaffordable() {
        assertEquals(0, Solution().maximumProfit(intArrayOf(4, 3), intArrayOf(5, 3), 3))
    }

    @Test
    fun bothAffordable() {
        assertEquals(6, Solution().maximumProfit(intArrayOf(2, 2), intArrayOf(5, 5), 4))
    }

    @Test
    fun chooseOne() {
        assertEquals(2, Solution().maximumProfit(intArrayOf(3, 4), intArrayOf(5, 6), 6))
    }

    @Test
    fun noProfit() {
        assertEquals(0, Solution().maximumProfit(intArrayOf(5), intArrayOf(3), 10))
    }
}
