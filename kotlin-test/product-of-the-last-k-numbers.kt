package productofthelastknumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductOfNumbersTest {
    @Test
    fun validCase1_accumulatesProducts() {
        val product = ProductOfNumbers()
        product.add(3)
        product.add(2)
        product.add(5)
        assertEquals(30, product.getProduct(3))
    }

    @Test
    fun validCase2_singleNumber() {
        val product = ProductOfNumbers()
        product.add(7)
        assertEquals(7, product.getProduct(1))
    }

    @Test
    fun validCase3_kBeforeLatestNumber() {
        val product = ProductOfNumbers()
        listOf(3, 0, 2, 5, 4).forEach(product::add)
        assertEquals(20, product.getProduct(2))
    }

    @Test
    fun validCase4_immediatelyAfterZero() {
        val product = ProductOfNumbers()
        listOf(3, 0, 2).forEach(product::add)
        assertEquals(0, product.getProduct(2))
    }

    @Test
    fun validCase5_zeroInsideWindow() {
        val product = ProductOfNumbers()
        listOf(3, 0, 2, 0, 4).forEach(product::add)
        assertEquals(4, product.getProduct(1))
        assertEquals(0, product.getProduct(2))
    }

    @Test
    fun validCase6_oldValuesDoNotLeakAcrossReset() {
        val product = ProductOfNumbers()
        listOf(2, 3, 4, 0, 5, 6).forEach(product::add)
        assertEquals(30, product.getProduct(2))
        assertEquals(0, product.getProduct(3))
    }
}
