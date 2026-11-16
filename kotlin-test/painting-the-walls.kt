package paintingthewalls

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaintingTheWallsTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(3, solution.paintWalls(intArrayOf(1, 2, 3, 2), intArrayOf(1, 2, 3, 2)))
        assertEquals(4, solution.paintWalls(intArrayOf(2, 3, 4, 2), intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun singleWall() {
        assertEquals(7, solution.paintWalls(intArrayOf(7), intArrayOf(0)))
    }

    @Test
    fun paidWallCoversRemainingWalls() {
        assertEquals(1, solution.paintWalls(intArrayOf(1, 2, 3), intArrayOf(2, 0, 0)))
    }

    @Test
    fun noWalls() {
        assertEquals(0, solution.paintWalls(intArrayOf(), intArrayOf()))
    }
}
