package numberofislands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfIslandsTest {
    @Test
    fun countsSingleIsland() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )
        assertEquals(1, Solution().numIslands(grid))
    }

    @Test
    fun countsThreeSeparateIslands() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )
        assertEquals(3, Solution().numIslands(grid))
    }

    @Test
    fun returnsZeroForEmptyGridOrAllWater() {
        assertEquals(0, Solution().numIslands(emptyArray()))
        val grid = arrayOf(charArrayOf('0', '0'), charArrayOf('0', '0'))
        assertEquals(0, Solution().numIslands(grid))
    }

    @Test
    fun doesNotJoinDiagonalLand() {
        val grid = arrayOf(charArrayOf('1', '0'), charArrayOf('0', '1'))
        assertEquals(2, Solution().numIslands(grid))
    }
}
