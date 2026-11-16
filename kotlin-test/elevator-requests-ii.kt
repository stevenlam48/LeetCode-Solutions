package elevatorrequestsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ElevatorRequestsIiTest {
    @Test
    fun noRequestsReturnsZero() {
        assertEquals(0L, Solution().elevatorRequests(10, 5, intArrayOf()))
    }

    @Test
    fun singleRequestReturnsDistanceFromStart() {
        assertEquals(2L, Solution().elevatorRequests(10, 5, intArrayOf(7)))
    }

    @Test
    fun requestsOnOppositeSides() {
        assertEquals(12L, Solution().elevatorRequests(10, 5, intArrayOf(8, 2)))
    }

    @Test
    fun requestsOnSameSide() {
        assertEquals(5L, Solution().elevatorRequests(10, 5, intArrayOf(2, 3)))
    }

    @Test
    fun duplicateRequestsAreRetained() {
        assertEquals(6L, Solution().elevatorRequests(10, 5, intArrayOf(5, 2, 2)))
    }
}
