package circleandrectangleoverlapping

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CircleAndRectangleOverlappingTest {
    private val solution = Solution()

    @Test
    fun separatedCircleAndRectangle() {
        assertFalse(solution.checkOverlap(1, 0, 0, 1, 1, 3, 3))
    }

    @Test
    fun rectangleCrossesCircleCenter() {
        assertTrue(solution.checkOverlap(1, 0, 0, -1, 0, 1, 0))
    }

    @Test
    fun circleCenterInsideRectangle() {
        assertTrue(solution.checkOverlap(1, 1, 1, 1, 1, 3, 3))
    }

    @Test
    fun tangencyCountsAsOverlap() {
        assertTrue(solution.checkOverlap(5, 0, 0, 3, 4, 6, 8))
    }

    @Test
    fun nearestCornerOutsideCircle() {
        assertFalse(solution.checkOverlap(4, 0, 0, 3, 4, 6, 8))
    }
}
