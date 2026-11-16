package maximumtotalvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalValueTest {
    @Test
    fun selectsLargestValues() {
        assertEquals(25, Solution().maxTotalValue(intArrayOf(10, 8), intArrayOf(3, 2), 3))
        assertEquals(35, Solution().maxTotalValue(intArrayOf(10, 8), intArrayOf(3, 2), 5))
    }

    @Test
    fun takesEveryAvailableValue() {
        assertEquals(9, Solution().maxTotalValue(intArrayOf(5), intArrayOf(2), 10))
        assertEquals(5, Solution().maxTotalValue(intArrayOf(3, 2), intArrayOf(5, 5), 2))
    }

    @Test
    fun zeroSelections() {
        assertEquals(0, Solution().maxTotalValue(intArrayOf(1, 2), intArrayOf(1, 1), 0))
    }
}
