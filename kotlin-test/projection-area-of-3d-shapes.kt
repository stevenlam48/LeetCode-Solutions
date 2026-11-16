package projectionareaof3dshapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProjectionAreaOf3DShapesTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.projectionArea(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        assertEquals(17, actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.projectionArea(arrayOf(intArrayOf(1, 0), intArrayOf(0, 2)))
        assertEquals(8, actual)
    }

    @Test
    fun validCase3() {
        val actual = solution.projectionArea(
            arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
        )
        assertEquals(14, actual)
    }

    @Test
    fun validCase4_singleCubeStack() {
        val actual = solution.projectionArea(arrayOf(intArrayOf(5)))
        assertEquals(11, actual)
    }

    @Test
    fun validCase5_emptyGrid() {
        val actual = solution.projectionArea(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))
        assertEquals(0, actual)
    }

    @Test
    fun validCase6_sparseGrid() {
        val actual = solution.projectionArea(
            arrayOf(intArrayOf(2, 0, 0), intArrayOf(0, 3, 0), intArrayOf(0, 0, 4))
        )
        assertEquals(21, actual)
    }
}
