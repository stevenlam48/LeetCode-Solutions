package findminimumtimetofinishalljobsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumTimeToFinishAllJobsIITest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minimumTime(intArrayOf(5, 2, 4), intArrayOf(1, 7, 5)))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().minimumTime(intArrayOf(3, 18, 15, 9), intArrayOf(6, 5, 1, 3)))
    }

    @Test
    fun singleJob() {
        assertEquals(3, Solution().minimumTime(intArrayOf(3), intArrayOf(1)))
    }

    @Test
    fun workerFasterThanJob() {
        assertEquals(1, Solution().minimumTime(intArrayOf(1, 2, 3), intArrayOf(10, 10, 10)))
    }

    @Test
    fun equalValues() {
        assertEquals(1, Solution().minimumTime(intArrayOf(5, 5), intArrayOf(5, 5)))
    }

    @Test
    fun exactDivision() {
        assertEquals(2, Solution().minimumTime(intArrayOf(4, 6), intArrayOf(2, 3)))
    }
}
