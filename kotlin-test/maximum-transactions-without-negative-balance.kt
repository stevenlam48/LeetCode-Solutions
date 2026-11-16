package maximumtransactionswithoutnegativebalance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTransactionsWithoutNegativeBalanceTest {
    @Test
    fun examples() {
        assertEquals(4, Solution().maxTransactions(intArrayOf(1, -4, 2, 3, -1)))
        assertEquals(2, Solution().maxTransactions(intArrayOf(-5, 2, 3)))
    }

    @Test
    fun removesMostNegativeTransaction() {
        assertEquals(3, Solution().maxTransactions(intArrayOf(10, -3, -4, -5)))
    }

    @Test
    fun emptyAndSingleTransactions() {
        assertEquals(0, Solution().maxTransactions(intArrayOf()))
        assertEquals(0, Solution().maxTransactions(intArrayOf(-1)))
        assertEquals(1, Solution().maxTransactions(intArrayOf(0)))
    }
}
