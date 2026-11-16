package minimumrectanglestocoverpoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRectanglesToCoverPointsTest {
    @Test
    fun example1() {
        val points = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 4),
            intArrayOf(1, 0),
            intArrayOf(3, 3)
        )
        assertEquals(1, Solution().minRectanglesToCoverPoints(points, 2))
    }

    @Test
    fun example2() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 3),
            intArrayOf(5, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 4)
        )
        assertEquals(2, Solution().minRectanglesToCoverPoints(points, 3))
    }

    @Test
    fun singlePoint() {
        val points = arrayOf(intArrayOf(0, 0))
        assertEquals(1, Solution().minRectanglesToCoverPoints(points, 5))
    }

    @Test
    fun zeroWidth() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 5),
            intArrayOf(1, 0)
        )
        assertEquals(2, Solution().minRectanglesToCoverPoints(points, 0))
    }

    @Test
    fun duplicateXCoordinates() {
        val points = arrayOf(
            intArrayOf(2, 7),
            intArrayOf(2, 1),
            intArrayOf(2, 9)
        )
        assertEquals(1, Solution().minRectanglesToCoverPoints(points, 0))
    }
}
