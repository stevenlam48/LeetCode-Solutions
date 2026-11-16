package minimumtotalpriceafterapplyingdiscounts

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumTotalPriceAfterApplyingDiscountsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(7.92, solution.minPrice(intArrayOf(2, 3, 1, 2), intArrayOf(1, 2)), 1e-9)
    }

    @Test
    fun testExample2() {
        assertEquals(0.99, solution.minPrice(intArrayOf(1), intArrayOf(1)), 1e-9)
    }

    @Test
    fun testNoDiscounts() {
        assertEquals(6.0, solution.minPrice(intArrayOf(1, 2, 3), intArrayOf()), 1e-9)
    }

    @Test
    fun testMoreDiscountsThanPrices() {
        assertEquals(0.0, solution.minPrice(intArrayOf(5), intArrayOf(100, 50)), 1e-9)
    }

    @Test
    fun testZeroDiscount() {
        assertEquals(10.0, solution.minPrice(intArrayOf(4, 6), intArrayOf(0)), 1e-9)
    }
}
