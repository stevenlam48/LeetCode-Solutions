package minimumdiscardstobalanceinventory
// Time:  O(n)
// Space: O(w)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDiscardsToBalanceInventoryTest {
    private val solution = Solution()

    @Test
    fun discardArrivalExceedingFrequencyLimit() {
        assertEquals(1, solution.minArrivalsToDiscard(intArrayOf(1, 2, 1, 1), 4, 2))
    }

    @Test
    fun expiredArrivalsLeaveActiveWindow() {
        assertEquals(0, solution.minArrivalsToDiscard(intArrayOf(1, 1, 2, 1), 2, 2))
    }

    @Test
    fun discardedArrivalsDoNotCountLater() {
        assertEquals(3, solution.minArrivalsToDiscard(intArrayOf(7, 7, 7, 7), 4, 1))
    }

    @Test
    fun emptyAndSparseArrivals() {
        assertEquals(0, solution.minArrivalsToDiscard(intArrayOf(), 3, 2))
        assertEquals(0, solution.minArrivalsToDiscard(intArrayOf(1, 2, 3), 3, 1))
    }
}
