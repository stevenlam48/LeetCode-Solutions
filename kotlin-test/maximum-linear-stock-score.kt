package maximumlinearstockscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLinearStockScoreTest {
    private val solution = Solution()

    @Test
    fun `groups prices by their adjusted values`() {
        assertEquals(10L, solution.maxScore(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `selects only one group`() {
        assertEquals(5L, solution.maxScore(intArrayOf(5, 1, 4, 3)))
    }

    @Test
    fun `sums a multi-element winning group`() {
        assertEquals(8L, solution.maxScore(intArrayOf(1, 5, 3, 4)))
    }

    @Test
    fun `handles a single price`() {
        assertEquals(7L, solution.maxScore(intArrayOf(7)))
    }
}
