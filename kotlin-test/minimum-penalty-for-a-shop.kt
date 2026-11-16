package minimumpenaltyforashop

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumPenaltyForAShopTest {
    private val solution = Solution()

    @Test
    fun mixedCustomersWithTiedMinimumUsesEarliestHour() {
        assertEquals(2, solution.bestClosingTime("YYNY"))
    }

    @Test
    fun allHoursWithoutCustomersFavorImmediateClosing() {
        assertEquals(0, solution.bestClosingTime("NNNNN"))
    }

    @Test
    fun customersEveryHourFavorClosingAtEnd() {
        assertEquals(4, solution.bestClosingTime("YYYY"))
    }

    @Test
    fun singleCustomerCoversBothCustomerOutcomes() {
        assertEquals(1, solution.bestClosingTime("Y"))
        assertEquals(0, solution.bestClosingTime("N"))
    }
}
