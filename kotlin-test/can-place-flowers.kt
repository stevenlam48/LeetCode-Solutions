package canplaceflowers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanPlaceFlowersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
    }

    @Test
    fun testSingleEmptyPlot() {
        assertTrue(solution.canPlaceFlowers(intArrayOf(0), 1))
        assertFalse(solution.canPlaceFlowers(intArrayOf(0), 2))
    }

    @Test
    fun testSingleOccupiedPlot() {
        assertTrue(solution.canPlaceFlowers(intArrayOf(1), 0))
        assertFalse(solution.canPlaceFlowers(intArrayOf(1), 1))
    }

    @Test
    fun testEdgePlots() {
        assertTrue(solution.canPlaceFlowers(intArrayOf(0, 0, 1), 1))
        assertTrue(solution.canPlaceFlowers(intArrayOf(1, 0, 0), 1))
    }
}
