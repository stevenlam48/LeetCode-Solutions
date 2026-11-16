package maximumtotalsubarrayvaluei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalSubarrayValueITest {
    @Test
    fun examples() {
        assertEquals(4L, Solution().maxTotalValue(intArrayOf(1, 3, 2), 2))
        assertEquals(12L, Solution().maxTotalValue(intArrayOf(4, 2, 5, 1), 3))
    }

    @Test
    fun negativeValues() {
        assertEquals(14L, Solution().maxTotalValue(intArrayOf(-7, -2, -9), 2))
    }

    @Test
    fun equalValues() {
        assertEquals(0L, Solution().maxTotalValue(intArrayOf(5), 3))
        assertEquals(0L, Solution().maxTotalValue(intArrayOf(4, 4, 4), 5))
    }
}
