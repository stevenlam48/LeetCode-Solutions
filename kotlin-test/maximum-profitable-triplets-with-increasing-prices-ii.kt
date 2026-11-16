package maximumprofitabletripletswithincreasingpricesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProfitableTripletsWithIncreasingPricesIITest {
    private val solution = Solution()

    @Test
    fun exampleWithLargeUnusableProfit() {
        assertEquals(19, solution.maxProfit(intArrayOf(10, 2, 3, 4), intArrayOf(100, 2, 7, 10)))
    }

    @Test
    fun allPricesIncreasing() {
        assertEquals(15, solution.maxProfit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 5, 3, 4, 6)))
    }

    @Test
    fun duplicatePricesCannotBeReused() {
        assertEquals(13, solution.maxProfit(intArrayOf(1, 1, 2, 2, 3), intArrayOf(4, 5, 6, 1, 2)))
    }

    @Test
    fun fewerThanThreeElements() {
        assertEquals(-1, solution.maxProfit(intArrayOf(1, 2), intArrayOf(4, 8)))
    }

    @Test
    fun decreasingPrices() {
        assertEquals(-1, solution.maxProfit(intArrayOf(3, 2, 1), intArrayOf(100, 100, 100)))
    }
}
