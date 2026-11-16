package numberofordersinthebacklog

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfOrdersInTheBacklogTest {
    @Test
    fun matchesSellOrdersAgainstHighestBuyPrice() {
        val orders = arrayOf(
            intArrayOf(10, 5, 0),
            intArrayOf(15, 2, 1),
            intArrayOf(25, 1, 1),
            intArrayOf(30, 4, 0)
        )
        assertEquals(6, Solution().getNumberOfBacklogOrders(orders))
    }

    @Test
    fun appliesModuloToLargeUnmatchedAmounts() {
        val orders = arrayOf(
            intArrayOf(7, 1_000_000_000, 0),
            intArrayOf(15, 3, 1),
            intArrayOf(5, 999_999_997, 0),
            intArrayOf(17, 999_999_998, 1)
        )
        assertEquals(999_999_984, Solution().getNumberOfBacklogOrders(orders))
    }

    @Test
    fun partiallyMatchesAndKeepsRemainingBuyAmounts() {
        val orders = arrayOf(
            intArrayOf(10, 5, 0),
            intArrayOf(9, 3, 0),
            intArrayOf(10, 4, 1)
        )
        assertEquals(4, Solution().getNumberOfBacklogOrders(orders))
    }

    @Test
    fun completeMatchesLeaveNoBacklog() {
        val orders = arrayOf(intArrayOf(10, 5, 0), intArrayOf(10, 5, 1))
        assertEquals(0, Solution().getNumberOfBacklogOrders(orders))
    }

    @Test
    fun emptyInputHasNoBacklog() {
        assertEquals(0, Solution().getNumberOfBacklogOrders(arrayOf()))
    }
}
