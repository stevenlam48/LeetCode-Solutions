package themazeiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheMazeIIITest {

    private val maze = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )

    @Test
    fun testReachable() {
        assertEquals("dr", Solution().findShortestWay(maze, intArrayOf(0, 0), intArrayOf(2, 4)))
    }

    @Test
    fun testUnreachableWall() {
        assertEquals("impossible", Solution().findShortestWay(maze, intArrayOf(0, 0), intArrayOf(1, 2)))
    }

    @Test
    fun testBallStartsAtHole() {
        assertEquals("", Solution().findShortestWay(maze, intArrayOf(0, 0), intArrayOf(0, 0)))
    }

    @Test
    fun testSingleCell() {
        assertEquals("", Solution().findShortestWay(arrayOf(intArrayOf(0)), intArrayOf(0, 0), intArrayOf(0, 0)))
    }

    @Test
    fun testUnreachableRegion() {
        val blocked = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0)
        )
        assertEquals("impossible", Solution().findShortestWay(blocked, intArrayOf(0, 0), intArrayOf(2, 2)))
    }
}
