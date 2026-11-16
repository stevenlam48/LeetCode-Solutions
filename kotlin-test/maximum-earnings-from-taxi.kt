package maximumearningsfromtaxi
// Time:  O(n + mlogm), m is the number of rides
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumEarningsFromTaxiTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        val rides = arrayOf(intArrayOf(2, 5, 4), intArrayOf(1, 5, 1))
        assertEquals(7L, solution.maxTaxiEarnings(5, rides))
    }

    @Test
    fun combinesCompatibleUnsortedRides() {
        val rides = arrayOf(intArrayOf(2, 4, 1), intArrayOf(1, 2, 3))
        assertEquals(7L, solution.maxTaxiEarnings(4, rides))
    }

    @Test
    fun skipsLowerValueOverlappingRide() {
        val rides = arrayOf(intArrayOf(1, 4, 1), intArrayOf(2, 3, 10))
        assertEquals(11L, solution.maxTaxiEarnings(4, rides))
    }

    @Test
    fun noRidesEarnsZero() {
        assertEquals(0L, solution.maxTaxiEarnings(3, emptyArray()))
    }
}
