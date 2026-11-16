package brickwall

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BrickWallTest {
    @Test
    fun example1() {
        val wall = arrayOf(
            intArrayOf(1, 2, 2, 1),
            intArrayOf(3, 1, 2),
            intArrayOf(1, 3, 2),
            intArrayOf(2, 4),
            intArrayOf(3, 1, 2),
            intArrayOf(1, 3, 1, 1)
        )
        assertEquals(2, Solution().leastBricks(wall))
    }

    @Test
    fun singleBrickRows() {
        val wall = arrayOf(
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1)
        )
        assertEquals(3, Solution().leastBricks(wall))
    }

    @Test
    fun alignedSeam() {
        val wall = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2),
            intArrayOf(1, 1)
        )
        assertEquals(1, Solution().leastBricks(wall))
    }

    @Test
    fun singleRow() {
        val wall = arrayOf(intArrayOf(1, 1, 1))
        assertEquals(0, Solution().leastBricks(wall))
    }
}
