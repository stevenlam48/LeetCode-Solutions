package minimumtimetobreaklocksii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeToBreakLocksIiTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(4, solution.findMinimumTime(intArrayOf(3, 4, 1)))
        assertEquals(3, solution.findMinimumTime(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testFourLocks() {
        assertEquals(10, solution.findMinimumTime(intArrayOf(10, 3, 7, 2)))
    }

    @Test
    fun testEqualStrength() {
        assertEquals(10, solution.findMinimumTime(intArrayOf(5, 5, 5)))
    }

    @Test
    fun testSingleLock() {
        assertEquals(7, solution.findMinimumTime(intArrayOf(7)))
    }

    @Test
    fun testTwoLocks() {
        assertEquals(6, solution.findMinimumTime(intArrayOf(2, 4, 6)))
    }
}
