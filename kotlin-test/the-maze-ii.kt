package themazeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheMazeIITest {

    private val maze = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )

    @Test
    fun testReachable() {
        assertEquals(6, Solution().shortestDistance(maze, intArrayOf(0, 0), intArrayOf(2, 4)))
    }

    @Test
    fun testUnreachableWall() {
        assertEquals(-1, Solution().shortestDistance(maze, intArrayOf(0, 0), intArrayOf(1, 2)))
    }

    @Test
    fun testStartEqualsDestination() {
        assertEquals(0, Solution().shortestDistance(maze, intArrayOf(0, 0), intArrayOf(0, 0)))
    }

    @Test
    fun testSingleCell() {
        assertEquals(0, Solution().shortestDistance(arrayOf(intArrayOf(0)), intArrayOf(0, 0), intArrayOf(0, 0)))
    }

    @Test
    fun testStraightLine() {
        val line = arrayOf(intArrayOf(0, 0, 0, 0, 0))
        assertEquals(4, Solution().shortestDistance(line, intArrayOf(0, 0), intArrayOf(0, 4)))
    }

    @Test
    fun testUnreachableRegion() {
        val blocked = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0)
        )
        assertEquals(-1, Solution().shortestDistance(blocked, intArrayOf(0, 0), intArrayOf(2, 2)))
    }
}
