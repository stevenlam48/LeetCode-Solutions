package elevatorrequestsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ElevatorRequestsITest {
    @Test
    fun mixedDirectionRequests() {
        assertEquals(6, Solution().elevatorRequests(5, intArrayOf(1, 4, 2)))
    }

    @Test
    fun repeatedFloorAndZeroStart() {
        assertEquals(3, Solution().elevatorRequests(3, intArrayOf(0, 2, 2, 1)))
    }

    @Test
    fun singleRequest() {
        assertEquals(4, Solution().elevatorRequests(4, intArrayOf(4)))
    }
}
