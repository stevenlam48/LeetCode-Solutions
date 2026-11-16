package wherewilltheballfall

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class WhereWillTheBallFallTest {
    private val solution = Solution()

    @Test
    fun example1() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(-1, -1, -1, 1, 1),
            intArrayOf(1, 1, 1, 1, -1),
            intArrayOf(-1, -1, -1, -1, -1)
        )
        assertArrayEquals(intArrayOf(1, -1, -1, -1, -1), solution.findBall(grid))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(-1), solution.findBall(arrayOf(intArrayOf(-1))))
    }

    @Test
    fun example3() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1)
        )
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4, -1), solution.findBall(grid))
    }

    @Test
    fun singleColumnRight() {
        assertArrayEquals(intArrayOf(-1), solution.findBall(arrayOf(intArrayOf(1))))
    }
}
