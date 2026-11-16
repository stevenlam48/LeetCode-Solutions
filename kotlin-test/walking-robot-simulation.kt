package walkingrobotsimulation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WalkingRobotSimulationTest {
    private val solution = Solution()

    @Test
    fun walksWithoutObstacles() {
        assertEquals(25, solution.robotSim(intArrayOf(4, -1, 3), emptyArray()))
    }

    @Test
    fun walksAroundObstacle() {
        assertEquals(
            65,
            solution.robotSim(intArrayOf(4, -1, 4, -2, 4), arrayOf(intArrayOf(2, 4)))
        )
    }

    @Test
    fun waitsBehindBlockingObstacle() {
        assertEquals(
            4,
            solution.robotSim(intArrayOf(2, -1, 2), arrayOf(intArrayOf(0, 1)))
        )
        assertEquals(0, solution.robotSim(intArrayOf(-1, -2), emptyArray()))
    }
}
