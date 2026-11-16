package distributemoneytomaximumchildren

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeMoneyToMaximumChildrenTest {
    private val solution = Solution()

    @Test
    fun avoidFourDollarDistribution() {
        assertEquals(1, solution.distMoney(20, 3))
    }

    @Test
    fun everyChildGetsEight() {
        assertEquals(2, solution.distMoney(16, 2))
    }

    @Test
    fun onlyMinimumAmountAvailable() {
        assertEquals(0, solution.distMoney(2, 2))
    }

    @Test
    fun notEnoughMoney() {
        assertEquals(-1, solution.distMoney(1, 2))
    }
}
