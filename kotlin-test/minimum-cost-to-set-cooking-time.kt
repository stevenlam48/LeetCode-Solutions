package minimumcosttosetcookingtime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToSetCookingTimeTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().minCostSetTime(1, 2, 1, 600))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().minCostSetTime(0, 1, 2, 76))
    }

    @Test
    fun zeroSeconds() {
        assertEquals(1, Solution().minCostSetTime(0, 1, 1, 0))
    }

    @Test
    fun oneMinute() {
        assertEquals(4, Solution().minCostSetTime(5, 1, 1, 60))
    }

    @Test
    fun singleDigit() {
        assertEquals(2, Solution().minCostSetTime(1, 1, 1, 9))
    }
}
