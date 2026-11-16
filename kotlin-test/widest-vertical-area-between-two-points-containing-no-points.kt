package widestverticalareabetweentwopointscontainingnopoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WidestVerticalAreaBetweenTwoPointsContainingNoPointsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        val points = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(9, 0),
            intArrayOf(1, 0),
            intArrayOf(1, 4),
            intArrayOf(5, 3),
            intArrayOf(8, 8)
        )
        assertEquals(3, solution.maxWidthOfVerticalArea(points))
    }

    @Test
    fun example2() {
        val points = arrayOf(
            intArrayOf(8, 7),
            intArrayOf(9, 9),
            intArrayOf(7, 4),
            intArrayOf(9, 7)
        )
        assertEquals(1, solution.maxWidthOfVerticalArea(points))
    }

    @Test
    fun singlePoint() {
        assertEquals(0, solution.maxWidthOfVerticalArea(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun duplicateXCoordinates() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 5),
            intArrayOf(10, 0),
            intArrayOf(10, 5)
        )
        assertEquals(10, solution.maxWidthOfVerticalArea(points))
    }
}
