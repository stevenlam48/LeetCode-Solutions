package minimumscoretriangulationofpolygon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumScoreTriangulationOfPolygonTest {
    @Test
    fun triangle() {
        assertEquals(6, Solution().minScoreTriangulation(intArrayOf(1, 2, 3)))
    }

    @Test
    fun example2() {
        assertEquals(144, Solution().minScoreTriangulation(intArrayOf(3, 7, 4, 5)))
    }

    @Test
    fun square() {
        assertEquals(18, Solution().minScoreTriangulation(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun allOnes() {
        assertEquals(2, Solution().minScoreTriangulation(intArrayOf(1, 1, 1, 1)))
    }
}
