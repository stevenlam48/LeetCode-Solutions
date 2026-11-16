package maximumpricetofillabag

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPriceToFillABagTest {
    @Test
    fun fillsWholeItemsByUnitPrice() {
        val items = arrayOf(intArrayOf(10, 2), intArrayOf(8, 1), intArrayOf(6, 3))
        assertEquals(18.0, Solution().maxPrice(items, 3), 1e-9)
    }

    @Test
    fun fillsFractionalItem() {
        val items = arrayOf(intArrayOf(10, 2), intArrayOf(8, 1), intArrayOf(6, 3))
        assertEquals(20.0, Solution().maxPrice(items, 4), 1e-9)
    }

    @Test
    fun insufficientTotalWeight() {
        val items = arrayOf(intArrayOf(10, 2), intArrayOf(8, 1), intArrayOf(6, 3))
        assertEquals(-1.0, Solution().maxPrice(items, 10), 1e-9)
    }

    @Test
    fun zeroCapacity() {
        assertEquals(0.0, Solution().maxPrice(arrayOf(intArrayOf(10, 2)), 0), 1e-9)
    }
}
