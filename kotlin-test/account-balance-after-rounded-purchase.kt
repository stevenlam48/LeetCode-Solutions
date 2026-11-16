package accountbalanceafterroundedpurchase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaccountbalanceafterroundedpurchaseTest {
    @Test
    fun example1() {
        assertEquals(90, Solution().accountBalanceAfterPurchase(9))
    }

    @Test
    fun example2() {
        assertEquals(80, Solution().accountBalanceAfterPurchase(15))
    }

    @Test
    fun zero() {
        assertEquals(100, Solution().accountBalanceAfterPurchase(0))
    }

    @Test
    fun roundsUp() {
        assertEquals(0, Solution().accountBalanceAfterPurchase(100))
    }

    @Test
    fun roundsDown() {
        assertEquals(100, Solution().accountBalanceAfterPurchase(4))
    }
}
