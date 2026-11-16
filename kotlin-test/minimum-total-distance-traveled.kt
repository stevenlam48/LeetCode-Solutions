package minimumtotaldistancetraveled

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumTotalDistanceTraveledTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val robot = intArrayOf(0, 4, 6)
        val factory = arrayOf(intArrayOf(2, 2), intArrayOf(6, 2))
        assertEquals(4L, solution.minimumTotalDistance(robot, factory))
    }

    @Test
    fun testExample2() {
        val robot = intArrayOf(1, -1)
        val factory = arrayOf(intArrayOf(-2, 1), intArrayOf(2, 1))
        assertEquals(2L, solution.minimumTotalDistance(robot, factory))
    }

    @Test
    fun testExample3() {
        val robot = intArrayOf(9, 11, 99, 101)
        val factory = arrayOf(
            intArrayOf(10, 1), intArrayOf(7, 1), intArrayOf(14, 1),
            intArrayOf(100, 1), intArrayOf(96, 1), intArrayOf(103, 1)
        )
        assertEquals(6L, solution.minimumTotalDistance(robot, factory))
    }

    @Test
    fun testSingleRobot() {
        val robot = intArrayOf(5)
        val factory = arrayOf(intArrayOf(10, 3))
        assertEquals(5L, solution.minimumTotalDistance(robot, factory))
    }
}
