package mostprofitassigningwork

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostProfitAssigningWorkTest {
    private val solution = Solution()

    @Test
    fun assignsEachWorkerTheMostProfitableAvailableJob() {
        assertEquals(
            100,
            solution.maxProfitAssignment(
                intArrayOf(2, 4, 6, 8, 10),
                intArrayOf(10, 20, 30, 40, 50),
                intArrayOf(4, 5, 6, 7)
            )
        )
    }

    @Test
    fun returnsZeroWhenNoWorkerCanDoAnyJob() {
        assertEquals(
            0,
            solution.maxProfitAssignment(intArrayOf(85, 47, 57), intArrayOf(24, 66, 99), intArrayOf(40, 25, 25))
        )
    }

    @Test
    fun choosesHighestProfitAmongJobsWithSameDifficulty() {
        assertEquals(
            110,
            solution.maxProfitAssignment(intArrayOf(1, 1, 2), intArrayOf(10, 30, 50), intArrayOf(1, 2, 1))
        )
    }
}
