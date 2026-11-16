package makingalargeisland

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakingALargeIslandTest {
    private fun gridOf(vararg rows: IntArray): Array<IntArray> = arrayOf(*rows)

    @Test
    fun testExample1() {
        assertEquals(3, Solution().largestIsland(gridOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }

    @Test
    fun testExample2() {
        assertEquals(4, Solution().largestIsland(gridOf(intArrayOf(1, 1), intArrayOf(1, 0))))
    }

    @Test
    fun testNoZeros() {
        assertEquals(4, Solution().largestIsland(gridOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun testAllZeros() {
        assertEquals(1, Solution().largestIsland(gridOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun testSingleCell() {
        assertEquals(1, Solution().largestIsland(gridOf(intArrayOf(0))))
    }

    @Test
    fun testBridgesTwoIslands() {
        val grid = gridOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1)
        )
        assertEquals(3, Solution().largestIsland(grid))
    }
}
