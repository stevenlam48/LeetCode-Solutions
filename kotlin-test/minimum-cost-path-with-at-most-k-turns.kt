package minimumcostpathwithatmostkturns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostPathWithAtMostKTurnsTest {
    @Test
    fun singleCell() {
        assertEquals(5, Solution().minCost(arrayOf(intArrayOf(5)), 0))
    }

    @Test
    fun twoByTwo() {
        assertEquals(7, Solution().minCost(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1))
        assertEquals(-1, Solution().minCost(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 0))
    }

    @Test
    fun twoByThree() {
        assertEquals(12, Solution().minCost(
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)), 1
        ))
    }

    @Test
    fun straightLinePaths() {
        assertEquals(6, Solution().minCost(arrayOf(intArrayOf(1, 2, 3)), 0))
        assertEquals(6, Solution().minCost(
            arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3)), 0
        ))
    }
}
