package maximumtastinessofcandybasket

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTastinessOfCandyBasketTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(8, solution.maximumTastiness(intArrayOf(13, 5, 1, 8, 21, 2), 3))
    }

    @Test
    fun duplicatePrices() {
        assertEquals(2, solution.maximumTastiness(intArrayOf(1, 3, 1), 2))
    }

    @Test
    fun allEqualPrices() {
        assertEquals(0, solution.maximumTastiness(intArrayOf(7, 7, 7, 7), 2))
    }

    @Test
    fun consecutivePrices() {
        assertEquals(2, solution.maximumTastiness(intArrayOf(1, 2, 3, 4, 5), 3))
    }

    @Test
    fun twoCandies() {
        assertEquals(999999999, solution.maximumTastiness(intArrayOf(1, 1000000000), 2))
    }
}
