package minimumtimetovisitdisappearingnodes

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumTimeToVisitDisappearingNodesTest {
    @Test
    fun nodesDisappearBeforeArrival() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 1), intArrayOf(0, 2, 4))
        assertArrayEquals(intArrayOf(0, 2, -1), Solution().minimumTime(3, edges, intArrayOf(1, 5, 1)))
    }

    @Test
    fun reachesNodeBeforeDisappearance() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertArrayEquals(intArrayOf(0, 1), Solution().minimumTime(2, edges, intArrayOf(1, 2)))
    }

    @Test
    fun shortestWeightedPath() {
        val edges = arrayOf(intArrayOf(0, 1, 5), intArrayOf(0, 2, 1), intArrayOf(2, 1, 1))
        assertArrayEquals(intArrayOf(0, 2, 1, -1), Solution().minimumTime(4, edges, intArrayOf(10, 10, 10, 1)))
    }

    @Test
    fun equalityWithDisappearanceTimeIsTooLate() {
        val edges = arrayOf(intArrayOf(0, 1, 3))
        assertArrayEquals(intArrayOf(0, -1), Solution().minimumTime(2, edges, intArrayOf(5, 3)))
    }
}
