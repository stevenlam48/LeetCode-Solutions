package totalcosttohirekworkers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCostToHireKWorkersTest {
    @Test
    fun example() {
        assertEquals(
            11L,
            Solution().totalCost(intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8), 3, 4),
        )
    }

    @Test
    fun exampleSmall() {
        assertEquals(4L, Solution().totalCost(intArrayOf(1, 2, 4, 1), 3, 3))
    }

    @Test
    fun singleCandidateWindow() {
        assertEquals(6L, Solution().totalCost(intArrayOf(1, 2, 3), 3, 1))
    }

    @Test
    fun hireEveryone() {
        assertEquals(6L, Solution().totalCost(intArrayOf(2, 1, 3), 3, 2))
    }
}
