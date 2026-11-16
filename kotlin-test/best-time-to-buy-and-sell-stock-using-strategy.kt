package besttimetobuyandsellstockusingstrategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockUsingStrategyTest {
    @Test
    fun example1() {
        assertEquals(10L, Solution().maxProfit(intArrayOf(4, 2, 8), intArrayOf(-1, 0, 1), 2))
    }

    @Test
    fun kEqualsOne() {
        assertEquals(3L, Solution().maxProfit(intArrayOf(1, 2), intArrayOf(1, 1), 1))
    }

    @Test
    fun strategyAlreadyOptimal() {
        assertEquals(10L, Solution().maxProfit(intArrayOf(1, 2, 3, 4), intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun kEqualsZero() {
        assertEquals(4L, Solution().maxProfit(intArrayOf(1, 2, 3), intArrayOf(1, 0, 1), 0))
    }

    @Test
    fun largeValuesDoNotOverflow() {
        assertEquals(
            2_000_000_000L,
            Solution().maxProfit(intArrayOf(1_000_000_000, 1_000_000_000), intArrayOf(1, 1), 0),
        )
    }
}
