package maximumarearectanglewithpointconstraintsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAreaRectangleWithPointConstraintsITest {
    private val solution = Solution()

    @Test
    fun fourCornersFormRectangle() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(1, 3), intArrayOf(3, 1), intArrayOf(3, 3))
        assertEquals(4, solution.maxRectangleArea(points))
    }

    @Test
    fun interiorPointInvalidatesRectangle() {
        val points = arrayOf(
            intArrayOf(1, 1), intArrayOf(1, 3), intArrayOf(3, 1),
            intArrayOf(3, 3), intArrayOf(2, 2)
        )
        assertEquals(-1, solution.maxRectangleArea(points))
    }

    @Test
    fun smallerRectanglesAvoidBorderPoints() {
        val points = arrayOf(
            intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(1, 3),
            intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 3)
        )
        assertEquals(2, solution.maxRectangleArea(points))
    }

    @Test
    fun fullGridHasUnitRectangles() {
        val points = Array(9) { i -> intArrayOf(i / 3, i % 3) }
        assertEquals(1, solution.maxRectangleArea(points))
    }

    @Test
    fun insufficientPoints() {
        assertEquals(-1, solution.maxRectangleArea(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2))))
    }
}
