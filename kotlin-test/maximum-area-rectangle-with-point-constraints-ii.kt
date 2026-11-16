package maximumarearectanglewithpointconstraintsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAreaRectangleWithPointConstraintsIITest {
    private val solution = Solution()

    @Test
    fun fourCornersFormRectangle() {
        assertEquals(4L, solution.maxRectangleArea(intArrayOf(1, 1, 3, 3), intArrayOf(1, 3, 1, 3)))
    }

    @Test
    fun interiorPointInvalidatesRectangle() {
        assertEquals(
            -1L,
            solution.maxRectangleArea(intArrayOf(1, 1, 3, 3, 2), intArrayOf(1, 3, 1, 3, 2))
        )
    }

    @Test
    fun smallerRectanglesAvoidBorderPoints() {
        assertEquals(
            2L,
            solution.maxRectangleArea(intArrayOf(1, 1, 1, 3, 3, 3), intArrayOf(1, 2, 3, 1, 2, 3))
        )
    }

    @Test
    fun largeAreaUsesLongArithmetic() {
        assertEquals(
            1_000_000_000_000_000_000L,
            solution.maxRectangleArea(
                intArrayOf(0, 0, 1_000_000_000, 1_000_000_000),
                intArrayOf(0, 1_000_000_000, 0, 1_000_000_000)
            )
        )
    }

    @Test
    fun emptyInput() {
        assertEquals(-1L, solution.maxRectangleArea(intArrayOf(), intArrayOf()))
    }
}
