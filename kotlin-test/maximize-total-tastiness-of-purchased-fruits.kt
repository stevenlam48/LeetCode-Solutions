package maximizetotaltastinessofpurchasedfruits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTotalTastinessOfPurchasedFruitsTest {
    @Test
    fun exampleOne() {
        assertEquals(
            13,
            Solution().maxTastiness(intArrayOf(10, 20, 20), intArrayOf(5, 6, 7), 20, 2)
        )
    }

    @Test
    fun singleCoupon() {
        assertEquals(
            12,
            Solution().maxTastiness(intArrayOf(10, 20, 20), intArrayOf(5, 6, 7), 20, 1)
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            15,
            Solution().maxTastiness(intArrayOf(10, 15, 7), intArrayOf(5, 6, 4), 20, 2)
        )
    }

    @Test
    fun exampleThree() {
        assertEquals(
            11,
            Solution().maxTastiness(intArrayOf(10, 10, 15, 20), intArrayOf(6, 5, 4, 3), 20, 1)
        )
    }

    @Test
    fun noBudget() {
        assertEquals(
            0,
            Solution().maxTastiness(intArrayOf(10), intArrayOf(5), 0, 1)
        )
    }
}
