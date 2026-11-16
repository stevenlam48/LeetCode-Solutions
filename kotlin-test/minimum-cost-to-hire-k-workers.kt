package minimumcosttohirekworkers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToHireKWorkersTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(105.0, solution.mincostToHireWorkers(intArrayOf(10, 20, 5), intArrayOf(70, 50, 30), 2), 1e-9)
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(
            30.666666666666668,
            solution.mincostToHireWorkers(intArrayOf(3, 1, 10, 10, 1), intArrayOf(4, 8, 2, 2, 7), 3),
            1e-9
        )
    }

    @Test
    fun hireEveryWorker() {
        assertEquals(6.0, solution.mincostToHireWorkers(intArrayOf(1, 2), intArrayOf(2, 4), 2), 1e-9)
    }

    @Test
    fun hireOneWorker() {
        assertEquals(6.0, solution.mincostToHireWorkers(intArrayOf(5, 3), intArrayOf(20, 6), 1), 1e-9)
    }
}
