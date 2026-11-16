package maximumpointsactivatedwithoneaddition

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPointsActivatedWithOneAdditionTest {
    @Test
    fun allPointsDisconnected() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3), intArrayOf(4, 4))
        assertEquals(3, Solution().maxActivated(points))
    }

    @Test
    fun oneConnectedComponent() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 2), intArrayOf(2, 3), intArrayOf(3, 3))
        assertEquals(6, Solution().maxActivated(points))
    }

    @Test
    fun twoComponents() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(2, 3))
        assertEquals(5, Solution().maxActivated(points))
    }

    @Test
    fun singlePoint() {
        assertEquals(2, Solution().maxActivated(arrayOf(intArrayOf(1, 2))))
    }
}
