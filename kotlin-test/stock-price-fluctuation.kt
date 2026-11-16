package stockpricefluctuation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StockPriceFluctuationTest {
    @Test
    fun testExampleSequence() {
        val stockPrice = StockPrice()
        stockPrice.update(1, 10)
        stockPrice.update(2, 5)
        assertEquals(5, stockPrice.current())
        assertEquals(10, stockPrice.maximum())
        assertEquals(5, stockPrice.minimum())
        stockPrice.update(1, 3)
        assertEquals(5, stockPrice.current())
        assertEquals(5, stockPrice.maximum())
        assertEquals(3, stockPrice.minimum())
        stockPrice.update(4, 2)
        assertEquals(2, stockPrice.current())
        assertEquals(5, stockPrice.maximum())
        assertEquals(2, stockPrice.minimum())
    }

    @Test
    fun testSingleUpdate() {
        val stockPrice = StockPrice()
        stockPrice.update(1, 7)
        assertEquals(7, stockPrice.current())
        assertEquals(7, stockPrice.maximum())
        assertEquals(7, stockPrice.minimum())
    }

    @Test
    fun testDuplicatePrices() {
        val stockPrice = StockPrice()
        stockPrice.update(1, 5)
        stockPrice.update(2, 5)
        stockPrice.update(3, 5)
        assertEquals(5, stockPrice.maximum())
        assertEquals(5, stockPrice.minimum())
        stockPrice.update(2, 9)
        assertEquals(9, stockPrice.maximum())
        assertEquals(5, stockPrice.minimum())
    }

    @Test
    fun testOverwriteMaximum() {
        val stockPrice = StockPrice()
        stockPrice.update(1, 100)
        stockPrice.update(2, 50)
        assertEquals(100, stockPrice.maximum())
        stockPrice.update(1, 10)
        assertEquals(50, stockPrice.maximum())
        assertEquals(10, stockPrice.minimum())
    }
}
