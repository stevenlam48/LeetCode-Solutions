package minimumnumberofsecondstomakemountainheightzero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfSecondsToMakeMountainHeightZeroTest {
    private val solution = Solution()

    @Test
    fun workersShareTheReductions() {
        assertEquals(3L, solution.minNumberOfSeconds(4, intArrayOf(2, 1, 1)))
    }

    @Test
    fun leetCodeExampleWithUnequalWorkerTimes() {
        assertEquals(12L, solution.minNumberOfSeconds(10, intArrayOf(3, 2, 2, 4)))
    }

    @Test
    fun singleWorkerNeedsTriangularTime() {
        assertEquals(15L, solution.minNumberOfSeconds(5, intArrayOf(1)))
    }

    @Test
    fun heightOneUsesFastestWorker() {
        assertEquals(2L, solution.minNumberOfSeconds(1, intArrayOf(7, 2, 5)))
    }

    @Test
    fun largeWorkerTimesUseLongArithmetic() {
        assertEquals(500005000000000L, solution.minNumberOfSeconds(100000, intArrayOf(100000)))
    }
}
