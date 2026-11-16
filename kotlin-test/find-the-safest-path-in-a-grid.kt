package findthesafestpathinagrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSafestPathInAGridTest {
    private val solution = Solution()

    @Test
    fun thievesAtBothEndpointsForceZeroSafeness() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(0, solution.maximumSafenessFactor(grid))
    }

    @Test
    fun pathCanMaintainDistanceTwoFromSingleThief() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(2, solution.maximumSafenessFactor(grid))
    }

    @Test
    fun multipleThievesLimitBestPathToTwo() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 0, 0, 0)
        )
        assertEquals(2, solution.maximumSafenessFactor(grid))
    }

    @Test
    fun singleCellGridHasZeroSafeness() {
        assertEquals(0, solution.maximumSafenessFactor(arrayOf(intArrayOf(1))))
    }
}
