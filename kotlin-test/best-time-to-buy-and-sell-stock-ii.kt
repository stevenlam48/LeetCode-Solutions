package besttimetobuyandsellstockii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockIiTest {
    @Test
    fun example1() {
        assertEquals(7, Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxProfit(intArrayOf(1)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().maxProfit(intArrayOf()))
    }
}
