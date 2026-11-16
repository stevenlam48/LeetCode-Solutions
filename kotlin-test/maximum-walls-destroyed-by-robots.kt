package maximumwallsdestroyedbyrobots

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumWallsDestroyedByRobotsTest {
    private val solution = Solution()

    @Test
    fun singleRobotChoosesTheBetterDirection() {
        assertEquals(2, solution.maxWalls(intArrayOf(1), intArrayOf(1), intArrayOf(1, 2, 3)))
    }

    @Test
    fun robotInTheMiddleOfThreeWalls() {
        assertEquals(2, solution.maxWalls(intArrayOf(2), intArrayOf(1), intArrayOf(1, 2, 3)))
    }

    @Test
    fun twoRobotsDestroyAllWalls() {
        assertEquals(3, solution.maxWalls(intArrayOf(1, 3), intArrayOf(1, 1), intArrayOf(1, 2, 3)))
    }

    @Test
    fun twoRobotsWithSeparatedRanges() {
        assertEquals(6, solution.maxWalls(intArrayOf(1, 5), intArrayOf(2, 2), intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun zeroDistanceStillDestroysWallAtItsPosition() {
        assertEquals(1, solution.maxWalls(intArrayOf(0), intArrayOf(0), intArrayOf(0)))
    }
}
