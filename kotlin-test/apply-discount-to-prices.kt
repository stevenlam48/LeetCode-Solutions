package applydiscounttoprices

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyDiscountToPricesTest {
    private val solution = Solution()

    @Test
    fun discountsValidPricesOnly() {
        assertEquals(
            "there are $0.50 $1.00 and 5$ candies in the shop",
            solution.discountPrices("there are $1 $2 and 5$ candies in the shop", 50)
        )
    }

    @Test
    fun fullDiscountUsesTwoDecimalPlaces() {
        assertEquals(
            "1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$",
            solution.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100)
        )
    }

    @Test
    fun preservesSpacesAndInvalidPrices() {
        assertEquals(
            "$  $1.20 $1a $-1 $$1",
            solution.discountPrices("$  $2 $1a $-1 $$1", 40)
        )
    }

    @Test
    fun largePriceDoesNotOverflowInt() {
        assertEquals("$1073741823.50", solution.discountPrices("$2147483647", 50))
    }
}
