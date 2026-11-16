package maximizeprofitfromtaskassignment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeProfitFromTaskAssignmentTest {
    @Test
    fun combinesMatchingTasksAndOneWildcard() {
        val workers = intArrayOf(1, 2, 3)
        val tasks = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 20),
            intArrayOf(2, 30),
            intArrayOf(4, 40)
        )
        assertEquals(80L, Solution().maxProfit(workers, tasks))
    }

    @Test
    fun wildcardAndMatchingTaskCanBothBeUsed() {
        val workers = intArrayOf(1)
        val tasks = arrayOf(intArrayOf(1, 4), intArrayOf(2, 10))
        assertEquals(14L, Solution().maxProfit(workers, tasks))
    }

    @Test
    fun duplicateWorkerSkillsAreCountedSeparately() {
        val workers = intArrayOf(5, 5)
        val tasks = arrayOf(
            intArrayOf(5, 7),
            intArrayOf(5, 9),
            intArrayOf(6, 100)
        )
        assertEquals(116L, Solution().maxProfit(workers, tasks))
    }

    @Test
    fun noTasksYieldZeroProfit() {
        assertEquals(0L, Solution().maxProfit(intArrayOf(1, 2), emptyArray()))
    }
}
