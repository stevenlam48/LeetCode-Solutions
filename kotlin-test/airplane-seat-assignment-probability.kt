package airplaneseatassignmentprobability

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AirplaneSeatAssignmentProbabilityTest {
    private val solution = Solution()

    @Test
    fun onePassenger() {
        assertEquals(1.0, solution.nthPersonGetsNthSeat(1), 0.0)
    }

    @Test
    fun twoPassengers() {
        assertEquals(0.5, solution.nthPersonGetsNthSeat(2), 0.0)
    }

    @Test
    fun manyPassengers() {
        assertEquals(0.5, solution.nthPersonGetsNthSeat(100000), 0.0)
    }
}
