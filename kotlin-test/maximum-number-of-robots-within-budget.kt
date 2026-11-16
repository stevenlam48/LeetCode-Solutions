package maximumnumberofrobotswithinbudget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofrobotswithinbudgetTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maximumRobots(intArrayOf(3, 6, 1, 3, 4), intArrayOf(2, 1, 3, 4, 5), 25L))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().maximumRobots(intArrayOf(11, 12, 19), intArrayOf(10, 8, 7), 19L))
    }

    @Test
    fun singleRobotFits() {
        assertEquals(1, Solution().maximumRobots(intArrayOf(1), intArrayOf(1), 2L))
    }

    @Test
    fun onlyCheapestFits() {
        assertEquals(1, Solution().maximumRobots(intArrayOf(1, 2), intArrayOf(1, 1), 4L))
    }
}
