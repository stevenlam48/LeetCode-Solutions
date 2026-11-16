package maximumtotalsumofkselectedelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalSumOfKSelectedElementsTest {
    @Test
    fun examples() {
        assertEquals(18L, Solution().maxSum(intArrayOf(1, 2, 3, 4), 2, 3))
        assertEquals(9L, Solution().maxSum(intArrayOf(1, 2, 3, 4), 3, 1))
    }

    @Test
    fun negativeValues() {
        assertEquals(-10L, Solution().maxSum(intArrayOf(-5, -2, -1), 2, 4))
    }

    @Test
    fun duplicatesAndLargeMultipliers() {
        assertEquals(36L, Solution().maxSum(intArrayOf(3, 3, 3), 3, 5))
    }
}
