package maximumnumberofitemsfromsalei

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfItemsFromSaleITest {
    private val solution = Solution()

    @Test
    fun zeroBudget() {
        val items = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 5))
        assertEquals(0, solution.maximumSaleItems(items, 0))
    }

    @Test
    fun singleSaleItem() {
        val items = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 5))
        assertEquals(3, solution.maximumSaleItems(items, 2))
    }

    @Test
    fun combineSaleItems() {
        val items = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 5))
        assertEquals(4, solution.maximumSaleItems(items, 5))
    }

    @Test
    fun frequencyMultiplesShareSaleValue() {
        val items = arrayOf(intArrayOf(4, 3), intArrayOf(8, 4))
        assertEquals(3, solution.maximumSaleItems(items, 6))
        assertEquals(3, solution.maximumSaleItems(items, 7))
    }

    @Test
    fun onlyRegularPurchasesAndOneSale() {
        val items = arrayOf(intArrayOf(1, 2))
        assertEquals(2, solution.maximumSaleItems(items, 5))
    }
}
