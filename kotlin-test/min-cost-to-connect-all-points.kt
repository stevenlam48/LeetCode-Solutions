package mincosttoconnectallpoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinCostToConnectAllPointsTest {
    @Test
    fun example1() {
        val points = arrayOf(
            intArrayOf(0, 0), intArrayOf(2, 2), intArrayOf(3, 10), intArrayOf(5, 2), intArrayOf(7, 0)
        )
        assertEquals(20, Solution().minCostConnectPoints(points))
    }

    @Test
    fun example2() {
        val points = arrayOf(intArrayOf(3, 12), intArrayOf(-2, 5), intArrayOf(-4, 1))
        assertEquals(18, Solution().minCostConnectPoints(points))
    }

    @Test
    fun singlePoint() {
        assertEquals(0, Solution().minCostConnectPoints(arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun twoPoints() {
        assertEquals(5, Solution().minCostConnectPoints(arrayOf(intArrayOf(0, 0), intArrayOf(2, 3))))
    }
}
