package elevatorrequestsiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ElevatorRequestsIvTest {
    @Test
    fun singleRequestWaitsForItsTime() {
        val requests = arrayOf(intArrayOf(8, 4))
        assertEquals(8, Solution().elevatorRequests(10, 1, requests))
    }

    @Test
    fun duplicateFloorsUseLatestTime() {
        val requests = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(7, 3),
            intArrayOf(4, 1)
        )
        assertEquals(7, Solution().elevatorRequests(10, 0, requests))
    }

    @Test
    fun choosesBetterEndpoint() {
        val requests = arrayOf(intArrayOf(0, 2), intArrayOf(0, 8))
        assertEquals(9, Solution().elevatorRequests(10, 5, requests))
    }

    @Test
    fun requestTimeChangesBestDirection() {
        val requests = arrayOf(intArrayOf(10, 2), intArrayOf(0, 8))
        assertEquals(10, Solution().elevatorRequests(10, 5, requests))
    }
}
