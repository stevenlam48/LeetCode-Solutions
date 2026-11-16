package maximumprofitinjobscheduling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProfitInJobSchedulingTest {
    @Test
    fun example1() {
        assertEquals(
            120,
            Solution().jobScheduling(
                intArrayOf(1, 2, 3, 3),
                intArrayOf(3, 4, 5, 6),
                intArrayOf(50, 10, 40, 70)
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            150,
            Solution().jobScheduling(
                intArrayOf(1, 2, 3, 4, 6),
                intArrayOf(3, 5, 10, 6, 9),
                intArrayOf(20, 20, 100, 70, 60)
            )
        )
    }

    @Test
    fun overlapping() {
        assertEquals(
            6,
            Solution().jobScheduling(intArrayOf(1, 1, 1), intArrayOf(2, 3, 4), intArrayOf(5, 6, 4))
        )
    }

    @Test
    fun singleJob() {
        assertEquals(7, Solution().jobScheduling(intArrayOf(1), intArrayOf(2), intArrayOf(7)))
    }

    @Test
    fun chainAllJobs() {
        assertEquals(
            10,
            Solution().jobScheduling(intArrayOf(1, 2, 3), intArrayOf(2, 3, 4), intArrayOf(1, 2, 7))
        )
    }
}
