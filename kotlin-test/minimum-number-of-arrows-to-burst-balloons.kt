package minimumnumberofarrowstoburstballoons

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumNumberOfArrowsToBurstBalloonsTest {
    @Test
    fun exampleWithOverlappingBalloons() {
        val points = arrayOf(
            intArrayOf(10, 16),
            intArrayOf(2, 8),
            intArrayOf(1, 6),
            intArrayOf(7, 12)
        )
        assertEquals(2, Solution().findMinArrowShots(points))
    }

    @Test
    fun disjointBalloonsNeedSeparateArrows() {
        val points = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6),
            intArrayOf(7, 8)
        )
        assertEquals(4, Solution().findMinArrowShots(points))
    }

    @Test
    fun touchingEndpointsCanShareArrows() {
        val points = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        assertEquals(2, Solution().findMinArrowShots(points))
    }

    @Test
    fun emptyInputNeedsNoArrows() {
        assertEquals(0, Solution().findMinArrowShots(emptyArray()))
    }

    @Test
    fun nestedAndNegativeIntervalsNarrowTheOverlap() {
        val points = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(-8, -2),
            intArrayOf(-10, -6)
        )
        assertEquals(2, Solution().findMinArrowShots(points))
    }
}
