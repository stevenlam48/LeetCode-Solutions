package themaze

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TheMazeTest {

    private val maze = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )

    @Test
    fun testReachable() {
        assertTrue(Solution().hasPath(maze, intArrayOf(0, 0), intArrayOf(2, 4)))
    }

    @Test
    fun testUnreachableWall() {
        assertFalse(Solution().hasPath(maze, intArrayOf(0, 0), intArrayOf(1, 2)))
    }

    @Test
    fun testStartEqualsDestination() {
        assertTrue(Solution().hasPath(maze, intArrayOf(0, 0), intArrayOf(0, 0)))
    }

    @Test
    fun testSingleCell() {
        assertTrue(Solution().hasPath(arrayOf(intArrayOf(0)), intArrayOf(0, 0), intArrayOf(0, 0)))
    }

    @Test
    fun testUnreachableRegion() {
        val blocked = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0)
        )
        assertFalse(Solution().hasPath(blocked, intArrayOf(0, 0), intArrayOf(2, 2)))
    }
}
