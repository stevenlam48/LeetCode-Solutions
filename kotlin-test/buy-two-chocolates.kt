package buytwochocolates

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BuyTwoChocolatesTest {
    @Test
    fun exactBudget() {
        assertEquals(0, Solution().buyChoco(intArrayOf(1, 2, 2), 3))
    }

    @Test
    fun cannotAffordTwoChocolates() {
        assertEquals(3, Solution().buyChoco(intArrayOf(3, 2, 3), 3))
    }

    @Test
    fun duplicateMinimumPrices() {
        assertEquals(0, Solution().buyChoco(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun leftoverMoney() {
        assertEquals(4, Solution().buyChoco(intArrayOf(2, 3, 9), 9))
    }
}
