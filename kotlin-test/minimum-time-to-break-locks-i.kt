package minimumtimetobreaklocksi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeToBreakLocksITest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(4, solution.findMinimumTime(intArrayOf(3, 4, 1), 1))
        assertEquals(3, solution.findMinimumTime(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun testLargerK() {
        assertEquals(5, solution.findMinimumTime(intArrayOf(2, 4, 6), 2))
        assertEquals(8, solution.findMinimumTime(intArrayOf(5, 5, 5), 3))
    }

    @Test
    fun testSingleLock() {
        assertEquals(1, solution.findMinimumTime(intArrayOf(1), 5))
    }

    @Test
    fun testFourLocks() {
        assertEquals(6, solution.findMinimumTime(intArrayOf(10, 3, 7, 2), 2))
    }
}
