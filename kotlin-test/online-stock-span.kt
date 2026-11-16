package onlinestockspan

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OnlineStockSpanTest {
    @Test
    fun testExample() {
        val spanner = StockSpanner()
        assertEquals(1, spanner.next(100))
        assertEquals(1, spanner.next(80))
        assertEquals(1, spanner.next(60))
        assertEquals(2, spanner.next(70))
        assertEquals(1, spanner.next(60))
        assertEquals(4, spanner.next(75))
        assertEquals(6, spanner.next(85))
    }

    @Test
    fun testIncreasing() {
        val spanner = StockSpanner()
        assertEquals(1, spanner.next(1))
        assertEquals(2, spanner.next(2))
        assertEquals(3, spanner.next(3))
    }

    @Test
    fun testDecreasing() {
        val spanner = StockSpanner()
        assertEquals(1, spanner.next(3))
        assertEquals(1, spanner.next(2))
        assertEquals(1, spanner.next(1))
    }
}
