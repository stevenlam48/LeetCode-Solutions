package findthepunishmentnumberofaninteger

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindThePunishmentNumberOfAnIntegerTest {
    private val solution = Solution()

    @Test
    fun punishmentNumberThroughTen() {
        assertEquals(182, solution.punishmentNumber(10))
    }

    @Test
    fun punishmentNumberThroughThirtySeven() {
        assertEquals(1478, solution.punishmentNumber(37))
    }

    @Test
    fun oneIsPunishing() {
        assertEquals(1, solution.punishmentNumber(1))
    }

    @Test
    fun zeroHasNoTerms() {
        assertEquals(0, solution.punishmentNumber(0))
    }
}
