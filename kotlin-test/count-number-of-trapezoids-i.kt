package countnumberoftrapezoidsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfTrapezoidsITest {
    private val solution = Solution()

    @Test
    fun twoHorizontalLevels() {
        val points = arrayOf(
            intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 0),
            intArrayOf(2, 2), intArrayOf(4, 2)
        )
        assertEquals(3, solution.countTrapezoids(points))
    }

    @Test
    fun threeHorizontalLevels() {
        val points = arrayOf(
            intArrayOf(0, 0), intArrayOf(1, 0),
            intArrayOf(0, 2), intArrayOf(1, 2),
            intArrayOf(0, 4), intArrayOf(1, 4)
        )
        assertEquals(3, solution.countTrapezoids(points))
    }

    @Test
    fun noPointsOrNoUsablePairs() {
        assertEquals(0, solution.countTrapezoids(emptyArray()))
        assertEquals(0, solution.countTrapezoids(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun singleHorizontalLevelCannotFormTrapezoid() {
        val points = Array(4) { intArrayOf(it, 3) }
        assertEquals(0, solution.countTrapezoids(points))
    }
}
