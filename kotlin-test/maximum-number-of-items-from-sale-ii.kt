package maximumnumberofitemsfromsaleii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfItemsFromSaleIITest {
    private val solution = Solution()

    @Test
    fun zeroBudget() {
        val items = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 5))
        assertEquals(0, solution.maximumSaleItems(items, 0))
    }

    @Test
    fun cheapestRegularPurchases() {
        val items = arrayOf(intArrayOf(1, 2))
        assertEquals(5, solution.maximumSaleItems(items, 10))
    }

    @Test
    fun combineSaleAndRegularPurchases() {
        val items = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(3, solution.maximumSaleItems(items, 5))
    }

    @Test
    fun exactSaleBudget() {
        val items = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(2, solution.maximumSaleItems(items, 2))
    }

    @Test
    fun frequencyMultiplesShareSaleValue() {
        val items = arrayOf(intArrayOf(4, 3), intArrayOf(8, 4))
        assertEquals(3, solution.maximumSaleItems(items, 7))
    }
}
