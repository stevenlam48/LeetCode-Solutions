package minimumtimetovisitacellinagrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToVisitACellInAGridTest {
    @Test
    fun reachesTargetWithWaiting() {
        val grid = arrayOf(intArrayOf(0, 1, 3, 2), intArrayOf(5, 1, 2, 5), intArrayOf(4, 3, 8, 6))
        assertEquals(7, Solution().minimumTime(grid))
    }

    @Test
    fun cannotLeaveStart() {
        val grid = arrayOf(intArrayOf(0, 2, 4), intArrayOf(3, 2, 1), intArrayOf(1, 0, 4))
        assertEquals(-1, Solution().minimumTime(grid))
    }

    @Test
    fun openGrid() {
        val grid = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(2, Solution().minimumTime(grid))
    }

    @Test
    fun choosesBetterParity() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(4, 4))
        assertEquals(4, Solution().minimumTime(grid))
    }
}
