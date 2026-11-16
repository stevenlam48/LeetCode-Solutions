package countrobotgroups

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountRobotGroupsTest {
    private val solution = Solution()

    @Test
    fun allRobotsFormOneGroup() {
        assertEquals(
            1,
            solution.countGroups(intArrayOf(1, 5, 9), intArrayOf(3, 2, 1), 1)
        )
    }

    @Test
    fun increasingSpeedsFormSeparateGroups() {
        assertEquals(
            3,
            solution.countGroups(intArrayOf(0, 10, 20), intArrayOf(1, 2, 3), 1)
        )
    }

    @Test
    fun closeRobotsAreSkipped() {
        assertEquals(
            1,
            solution.countGroups(intArrayOf(0, 5, 9, 10), intArrayOf(5, 4, 3, 2), 1)
        )
    }

    @Test
    fun singleRobot() {
        assertEquals(1, solution.countGroups(intArrayOf(4), intArrayOf(7), 0))
    }
}
