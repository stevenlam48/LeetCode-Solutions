package countnumberoftrapezoidsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfTrapezoidsIITest {
    private val solution = Solution()

    @Test
    fun leetCodeIrregularTrapezoid() {
        val points = arrayOf(
            intArrayOf(0, 0), intArrayOf(1, 0),
            intArrayOf(0, 1), intArrayOf(2, 1)
        )
        assertEquals(1, solution.countTrapezoids(points))
    }

    @Test
    fun parallelogramIsCountOnce() {
        val points = arrayOf(
            intArrayOf(0, 0), intArrayOf(2, 0),
            intArrayOf(3, 1), intArrayOf(1, 1)
        )
        assertEquals(1, solution.countTrapezoids(points))
    }

    @Test
    fun noParallelSides() {
        val points = arrayOf(
            intArrayOf(0, 0), intArrayOf(2, 0),
            intArrayOf(3, 2), intArrayOf(1, 3)
        )
        assertEquals(0, solution.countTrapezoids(points))
    }

    @Test
    fun collinearPointsDoNotFormTrapezoid() {
        val points = arrayOf(
            intArrayOf(0, 0), intArrayOf(1, 1),
            intArrayOf(2, 2), intArrayOf(3, 3)
        )
        assertEquals(0, solution.countTrapezoids(points))
    }
}
