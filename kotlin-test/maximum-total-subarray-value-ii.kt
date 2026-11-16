package maximumtotalsubarrayvalueii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalSubarrayValueIiTest {
    @Test
    fun examples() {
        assertEquals(4L, Solution().maxTotalValue(intArrayOf(1, 3, 2), 2))
        assertEquals(12L, Solution().maxTotalValue(intArrayOf(4, 2, 5, 1), 3))
    }

    @Test
    fun includesZeroValues() {
        assertEquals(5L, Solution().maxTotalValue(intArrayOf(1, 3, 2), 4))
        assertEquals(20L, Solution().maxTotalValue(intArrayOf(4, 2, 5, 1), 10))
    }

    @Test
    fun singleAndEqualValues() {
        assertEquals(0L, Solution().maxTotalValue(intArrayOf(7), 1))
        assertEquals(0L, Solution().maxTotalValue(intArrayOf(3, 3, 3), 6))
    }

    @Test
    fun negativeValues() {
        assertEquals(14L, Solution().maxTotalValue(intArrayOf(-7, -2, -9), 2))
    }
}
