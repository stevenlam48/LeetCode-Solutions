package findminimumtimetofinishalljobs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumTimeToFinishAllJobsTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minimumTimeRequired(intArrayOf(3, 2, 3), 3))
    }

    @Test
    fun example2() {
        assertEquals(11, Solution().minimumTimeRequired(intArrayOf(1, 2, 4, 7, 8), 2))
    }

    @Test
    fun singleWorker() {
        assertEquals(22, Solution().minimumTimeRequired(intArrayOf(1, 2, 4, 7, 8), 1))
    }

    @Test
    fun singleJob() {
        assertEquals(5, Solution().minimumTimeRequired(intArrayOf(5), 1))
    }

    @Test
    fun moreWorkersThanJobs() {
        assertEquals(1, Solution().minimumTimeRequired(intArrayOf(1, 1, 1), 3))
    }

    @Test
    fun equalJobs() {
        assertEquals(8, Solution().minimumTimeRequired(intArrayOf(4, 4, 4, 4), 2))
    }
}
