package maximalnetworkrank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximalNetworkRankTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val roads = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 3),
            intArrayOf(1, 2),
            intArrayOf(1, 3)
        )
        assertEquals(4, solution.maximalNetworkRank(4, roads))
    }

    @Test
    fun testExample2() {
        val roads = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 3),
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(2, 4)
        )
        assertEquals(5, solution.maximalNetworkRank(5, roads))
    }

    @Test
    fun testSingleRoad() {
        assertEquals(1, solution.maximalNetworkRank(2, arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun testNoRoads() {
        assertEquals(0, solution.maximalNetworkRank(2, arrayOf()))
    }
}
