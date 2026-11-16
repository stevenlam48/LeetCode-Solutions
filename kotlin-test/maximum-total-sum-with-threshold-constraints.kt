package maximumtotalsumwiththresholdconstraints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalSumWithThresholdConstraintsTest {
    @Test
    fun examples() {
        assertEquals(
            100L,
            Solution().maxSum(intArrayOf(10, 20, 30, 40), intArrayOf(1, 3, 2, 2))
        )
        assertEquals(205L, Solution().maxSum(intArrayOf(5, 100, 100), intArrayOf(3, 1, 2)))
    }

    @Test
    fun stopsAtFirstUnavailableElement() {
        assertEquals(0L, Solution().maxSum(intArrayOf(5, 6, 7), intArrayOf(2, 3, 2)))
        assertEquals(0L, Solution().maxSum(intArrayOf(9, 8), intArrayOf(2, 2)))
    }

    @Test
    fun includesNegativeValues() {
        assertEquals(5L, Solution().maxSum(intArrayOf(-5, 10), intArrayOf(1, 1)))
    }
}
