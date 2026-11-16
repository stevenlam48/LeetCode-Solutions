package applydiscounteverynorders

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyDiscountEveryNOrdersTest {
    @Test
    fun fullLeetCodeOperationSequence() {
        val cashier = Cashier(
            3,
            50,
            intArrayOf(1, 2, 3, 4, 5, 6, 7),
            intArrayOf(100, 200, 300, 400, 300, 200, 100)
        )
        assertEquals(500.0, cashier.getBill(intArrayOf(1, 2), intArrayOf(1, 2)), 1e-9)
        assertEquals(4000.0, cashier.getBill(intArrayOf(3, 7), intArrayOf(10, 10)), 1e-9)
        assertEquals(
            800.0,
            cashier.getBill(intArrayOf(1, 2, 3, 4, 5, 6, 7), IntArray(7) { 1 }),
            1e-9
        )
        assertEquals(4000.0, cashier.getBill(intArrayOf(4), intArrayOf(10)), 1e-9)
        assertEquals(4000.0, cashier.getBill(intArrayOf(7, 3), intArrayOf(10, 10)), 1e-9)
        assertEquals(
            7350.0,
            cashier.getBill(
                intArrayOf(7, 5, 3, 1, 6, 4, 2),
                intArrayOf(10, 10, 10, 9, 9, 9, 7)
            ),
            1e-9
        )
        assertEquals(2500.0, cashier.getBill(intArrayOf(2, 3, 5), intArrayOf(5, 3, 2)), 1e-9)
    }

    @Test
    fun discountOnEveryOrderWhenNIsOne() {
        val cashier = Cashier(1, 25, intArrayOf(1), intArrayOf(40))
        assertEquals(30.0, cashier.getBill(intArrayOf(1), intArrayOf(1)), 1e-9)
        assertEquals(60.0, cashier.getBill(intArrayOf(1), intArrayOf(2)), 1e-9)
    }

    @Test
    fun emptyBillStillCountsAsAnOrder() {
        val cashier = Cashier(2, 50, intArrayOf(1), intArrayOf(10))
        assertEquals(0.0, cashier.getBill(IntArray(0), IntArray(0)), 1e-9)
        assertEquals(5.0, cashier.getBill(intArrayOf(1), intArrayOf(1)), 1e-9)
    }
}
