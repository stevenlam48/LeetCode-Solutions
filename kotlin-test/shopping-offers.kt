package shoppingoffers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShoppingOffersTest {
    @Test
    fun combinesOffersWithIndividualPrices() {
        val special = arrayOf(intArrayOf(3, 0, 5), intArrayOf(1, 2, 10))
        assertEquals(14, Solution().shoppingOffers(intArrayOf(2, 5), special, intArrayOf(3, 2)))
    }

    @Test
    fun canReuseAnOffer() {
        val special = arrayOf(intArrayOf(1, 1, 0, 4), intArrayOf(2, 2, 1, 9))
        assertEquals(11, Solution().shoppingOffers(intArrayOf(2, 3, 4), special, intArrayOf(1, 2, 1)))
    }

    @Test
    fun handlesNoOffers() {
        assertEquals(12, Solution().shoppingOffers(intArrayOf(2, 3, 4), emptyArray(), intArrayOf(1, 2, 1)))
    }

    @Test
    fun rejectsOffersExceedingNeeds() {
        val special = arrayOf(intArrayOf(2, 0, 1), intArrayOf(1, 0, 2))
        assertEquals(7, Solution().shoppingOffers(intArrayOf(2, 5), special, intArrayOf(1, 1)))
    }
}
