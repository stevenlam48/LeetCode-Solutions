package bricksfallingwhenhit

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BricksFallingWhenHitTest {
    @Test
    fun singleHitDropsTwo() {
        val grid = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )
        val hits = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(2), Solution().hitBricks(grid, hits))
    }

    @Test
    fun noBrickFalls() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        val hits = arrayOf(intArrayOf(1, 1))
        assertArrayEquals(intArrayOf(0), Solution().hitBricks(grid, hits))
    }

    @Test
    fun middleHitDropsTwo() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 0)
        )
        val hits = arrayOf(intArrayOf(1, 0))
        assertArrayEquals(intArrayOf(2), Solution().hitBricks(grid, hits))
    }

    @Test
    fun twoHits() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 1, 0, 0)
        )
        val hits = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
        assertArrayEquals(intArrayOf(0, 0), Solution().hitBricks(grid, hits))
    }

    @Test
    fun hitEmptyCell() {
        val grid = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )
        val hits = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(0), Solution().hitBricks(grid, hits))
    }
}
