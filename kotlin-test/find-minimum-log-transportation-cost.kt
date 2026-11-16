package findminimumlogtransportationcost

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumLogTransportationCostTest {
    @Test
    fun example1() {
        assertEquals(5L, Solution().minCuttingCost(6, 5, 5))
    }

    @Test
    fun example2() {
        assertEquals(0L, Solution().minCuttingCost(4, 4, 6))
    }

    @Test
    fun example3() {
        assertEquals(6L, Solution().minCuttingCost(5, 4, 3))
    }

    @Test
    fun bothWithinLimit() {
        assertEquals(0L, Solution().minCuttingCost(1, 1, 1))
    }

    @Test
    fun largeValues() {
        assertEquals(1000000000000000000L, Solution().minCuttingCost(2000000000, 1, 1000000000))
    }

    @Test
    fun onlyOneExceeds() {
        assertEquals(35L, Solution().minCuttingCost(12, 2, 5))
    }
}
