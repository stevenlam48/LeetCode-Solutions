package checkiftherectanglecornerisreachable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfTheRectangleCornerIsReachableTest {
    private val solution = Solution()

    @Test
    fun testSingleCircleBlocking() {
        assertFalse(solution.canReachCorner(3, 3, arrayOf(intArrayOf(1, 1, 2))))
    }

    @Test
    fun testOutOfReachCircle() {
        assertTrue(solution.canReachCorner(3, 4, arrayOf(intArrayOf(2, 1, 1))))
    }

    @Test
    fun testTwoCirclesFormBarrier() {
        assertFalse(solution.canReachCorner(3, 3, arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 2, 1))))
    }

    @Test
    fun testCircleOutsideRightEdge() {
        assertTrue(solution.canReachCorner(4, 4, arrayOf(intArrayOf(6, 1, 1))))
    }

    @Test
    fun testNoCircles() {
        assertTrue(solution.canReachCorner(1, 1, emptyArray()))
    }

    @Test
    fun testConnectedCirclesClosePath() {
        assertFalse(
            solution.canReachCorner(
                5, 5,
                arrayOf(intArrayOf(1, 3, 2), intArrayOf(3, 1, 2), intArrayOf(3, 3, 2))
            )
        )
    }
}
