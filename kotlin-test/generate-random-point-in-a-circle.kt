package generaterandompointinacircle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.hypot

class GenerateRandomPointInACircleTest {
    @Test
    fun pointsStayInsideUnitCircle() {
        val solution = Solution(1.0, 0.0, 0.0)
        var maxDistance = 0.0
        repeat(1000) {
            val point = solution.randPoint()
            assertEquals(2, point.size)
            val distance = hypot(point[0], point[1])
            assertTrue(distance <= 1.0 + 1e-9)
            maxDistance = maxOf(maxDistance, distance)
        }
        assertTrue(maxDistance > 0.1)
    }

    @Test
    fun pointsStayInsideShiftedCircle() {
        val solution = Solution(5.0, 2.0, -3.0)
        repeat(1000) {
            val point = solution.randPoint()
            val distance = hypot(point[0] - 2.0, point[1] + 3.0)
            assertTrue(distance <= 5.0 + 1e-9)
        }
    }

    @Test
    fun zeroRadiusReturnsCenter() {
        val solution = Solution(0.0, 4.0, -7.0)
        repeat(10) {
            val point = solution.randPoint()
            assertEquals(4.0, point[0], 1e-12)
            assertEquals(-7.0, point[1], 1e-12)
        }
    }

    @Test
    fun pointsAreNotAllIdentical() {
        val solution = Solution(10.0, 0.0, 0.0)
        val first = solution.randPoint()
        var different = false
        repeat(100) {
            val point = solution.randPoint()
            if (hypot(point[0] - first[0], point[1] - first[1]) > 1e-6) {
                different = true
            }
        }
        assertTrue(different)
    }
}
