package numberofwaystoreachdestinationinthegrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToReachDestinationInTheGridTest {
    @Test
    fun zeroSteps() {
        assertEquals(1, Solution().numberOfWays(2, 2, 0, intArrayOf(0, 0), intArrayOf(0, 0)))
        assertEquals(0, Solution().numberOfWays(2, 2, 0, intArrayOf(0, 0), intArrayOf(0, 1)))
    }

    @Test
    fun oneStepReachesSameRowCell() {
        assertEquals(1, Solution().numberOfWays(2, 2, 1, intArrayOf(0, 0), intArrayOf(0, 1)))
    }

    @Test
    fun twoStepsReturnToSource() {
        assertEquals(2, Solution().numberOfWays(2, 2, 2, intArrayOf(0, 0), intArrayOf(0, 0)))
    }

    @Test
    fun twoStepsReachDiagonalCell() {
        assertEquals(2, Solution().numberOfWays(2, 2, 2, intArrayOf(0, 0), intArrayOf(1, 1)))
    }
}
