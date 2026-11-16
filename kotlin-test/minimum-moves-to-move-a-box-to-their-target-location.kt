package minimummovestomoveaboxtotheirtargetlocation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToMoveABoxToTheirTargetLocationTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            charArrayOf('#', '#', '#', '#', '#', '#'),
            charArrayOf('#', 'T', '#', '#', '#', '#'),
            charArrayOf('#', '.', '.', 'B', '.', '#'),
            charArrayOf('#', '.', '#', '#', '.', '#'),
            charArrayOf('#', '.', '.', '.', 'S', '#'),
            charArrayOf('#', '#', '#', '#', '#', '#')
        )
        assertEquals(3, solution.minPushBox(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            charArrayOf('#', '#', '#', '#', '#', '#'),
            charArrayOf('#', 'T', '#', '#', '#', '#'),
            charArrayOf('#', '.', '.', 'B', '.', '#'),
            charArrayOf('#', '#', '#', '#', '.', '#'),
            charArrayOf('#', '.', '.', '.', 'S', '#'),
            charArrayOf('#', '#', '#', '#', '#', '#')
        )
        assertEquals(-1, solution.minPushBox(grid))
    }

    @Test
    fun testOnePush() {
        val grid = arrayOf(
            charArrayOf('S', 'B', 'T')
        )
        assertEquals(1, solution.minPushBox(grid))
    }

    @Test
    fun testPlayerMovesThenPushes() {
        val grid = arrayOf(
            charArrayOf('S', '.', 'B', 'T')
        )
        assertEquals(1, solution.minPushBox(grid))
    }

    @Test
    fun testTwoPushes() {
        val grid = arrayOf(
            charArrayOf('S', '.', 'B', '.', 'T')
        )
        assertEquals(2, solution.minPushBox(grid))
    }

    @Test
    fun testCannotPush() {
        val grid = arrayOf(
            charArrayOf('B', 'S', 'T')
        )
        assertEquals(-1, solution.minPushBox(grid))
    }
}
