package bestpositionforaservicecentre

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestPositionForAServiceCentreTest {
    private val solution = Solution()

    @Test
    fun diamondAroundCentre() {
        assertEquals(
            4.0,
            solution.getMinDistSum(
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(2, 1))
            ),
            1e-5
        )
    }

    @Test
    fun twoPoints() {
        assertEquals(
            2.8284271247461903,
            solution.getMinDistSum(arrayOf(intArrayOf(1, 1), intArrayOf(3, 3))),
            1e-5
        )
    }

    @Test
    fun singlePoint() {
        assertEquals(0.0, solution.getMinDistSum(arrayOf(intArrayOf(1, 1))), 1e-5)
    }

    @Test
    fun collinearPointsUseMiddlePoint() {
        assertEquals(
            10.0,
            solution.getMinDistSum(
                arrayOf(intArrayOf(0, 0), intArrayOf(4, 0), intArrayOf(10, 0))
            ),
            1e-5
        )
    }

    @Test
    fun duplicatePointsCanBeMedian() {
        assertEquals(
            10.0,
            solution.getMinDistSum(
                arrayOf(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(10, 0))
            ),
            1e-5
        )
    }
}
