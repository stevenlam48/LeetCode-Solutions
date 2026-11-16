package minimumnumberofdaystodisconnectisland

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfDaysToDisconnectIslandTest {
    private val solution = Solution()

    @Test
    fun blockIslandNeedsTwoDays() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 0, 0)
        )
        assertEquals(2, solution.minDays(grid))
    }

    @Test
    fun noLandIsAlreadyDisconnected() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(0, solution.minDays(grid))
    }

    @Test
    fun separateIslandsNeedNoDays() {
        val grid = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0)
        )
        assertEquals(0, solution.minDays(grid))
    }

    @Test
    fun singleLandNeedsOneDay() {
        assertEquals(1, solution.minDays(arrayOf(intArrayOf(0, 1, 0))))
    }

    @Test
    fun articulationPointNeedsOneDay() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0)
        )
        assertEquals(1, solution.minDays(grid))
    }
}
