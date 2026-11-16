package minimumtimetocompletetrips

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToCompleteTripsTest {
    @Test
    fun differentRoutes() {
        assertEquals(3L, Solution().minimumTime(intArrayOf(1, 2, 3), 5))
    }

    @Test
    fun oneRoute() {
        assertEquals(6L, Solution().minimumTime(intArrayOf(2), 3))
    }

    @Test
    fun repeatedRouteTimes() {
        assertEquals(25L, Solution().minimumTime(intArrayOf(5, 10, 10), 9))
    }

    @Test
    fun zeroTrips() {
        assertEquals(1L, Solution().minimumTime(intArrayOf(4, 7), 0))
    }
}
