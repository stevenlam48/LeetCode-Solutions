package maximumprofitofoperatingacentennialwheel

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProfitOfOperatingACentennialWheelTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(3, solution.minOperationsMaxProfit(intArrayOf(8, 3), 5, 6))
    }

    @Test
    fun secondExample() {
        assertEquals(7, solution.minOperationsMaxProfit(intArrayOf(10, 9, 6), 6, 4))
    }

    @Test
    fun neverProfitable() {
        assertEquals(-1, solution.minOperationsMaxProfit(intArrayOf(3, 4, 0, 5, 1), 1, 92))
    }

    @Test
    fun finalPartialRideImprovesProfit() {
        assertEquals(3, solution.minOperationsMaxProfit(intArrayOf(9), 4, 1))
    }

    @Test
    fun noCustomers() {
        assertEquals(-1, solution.minOperationsMaxProfit(intArrayOf(0, 0), 5, 1))
    }
}
