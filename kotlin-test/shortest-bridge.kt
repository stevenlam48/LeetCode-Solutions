package shortestbridge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestBridgeTest {
    @Test
    fun connectsAdjacentIslands() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        assertEquals(1, Solution().shortestBridge(grid))
    }

    @Test
    fun bridgesTwoWaterCells() {
        val grid = arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 1))
        assertEquals(2, Solution().shortestBridge(grid))
    }

    @Test
    fun expandsFromAnEntireIsland() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(1, 0, 0, 0, 1),
            intArrayOf(1, 1, 1, 1, 1)
        )
        assertEquals(1, Solution().shortestBridge(grid))
    }
}
