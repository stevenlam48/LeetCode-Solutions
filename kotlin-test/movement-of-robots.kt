package movementofrobots

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovementOfRobotsTest {
    @Test
    fun example1() {
        assertEquals(8, Solution().sumDistance(intArrayOf(-2, 0, 2), "RLL", 3))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().sumDistance(intArrayOf(1, 0), "RL", 2))
    }

    @Test
    fun singleRobot() {
        assertEquals(0, Solution().sumDistance(intArrayOf(5), "R", 10))
    }

    @Test
    fun allSameDirection() {
        assertEquals(4, Solution().sumDistance(intArrayOf(0, 1, 2), "RRR", 1))
    }

    @Test
    fun largeValues() {
        assertEquals(
            999999979,
            Solution().sumDistance(intArrayOf(-1000000000, 1000000000), "LR", 1000000000)
        )
    }
}
