package shortestdistancefromallbuildings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestDistanceFromAllBuildingsTest {
    @Test
    fun findsBestMeetingPoint() {
        val grid = arrayOf(
            intArrayOf(1, 0, 2, 0, 1),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 0)
        )
        assertEquals(7, Solution().shortestDistance(grid))
    }

    @Test
    fun handlesSingleBuilding() {
        val grid = arrayOf(intArrayOf(1, 0), intArrayOf(0, 0))
        assertEquals(1, Solution().shortestDistance(grid))
    }

    @Test
    fun returnsMinusOneWhenNoLandCanReachEveryBuilding() {
        assertEquals(-1, Solution().shortestDistance(arrayOf(intArrayOf(1, 2, 0, 2, 1))))
        assertEquals(-1, Solution().shortestDistance(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun avoidsObstacles() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0, 1),
            intArrayOf(0, 2, 2, 2, 0),
            intArrayOf(0, 0, 0, 0, 0)
        )
        assertEquals(4, Solution().shortestDistance(grid))
    }
}
