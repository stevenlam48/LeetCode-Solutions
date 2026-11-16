package checkifthereisavalidpathinagrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfThereIsAValidPathInAGridTest {
    private val solution = Solution()

    @Test
    fun testConnectedGrid() {
        val grid = arrayOf(
            intArrayOf(2, 4, 3),
            intArrayOf(6, 5, 2)
        )
        assertTrue(solution.hasValidPath(grid))
    }

    @Test
    fun testDisconnectedGrid() {
        val grid = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(1, 2, 1)
        )
        assertFalse(solution.hasValidPath(grid))
    }

    @Test
    fun testSingleRowBlocked() {
        assertFalse(solution.hasValidPath(arrayOf(intArrayOf(1, 1, 2))))
    }

    @Test
    fun testSingleCell() {
        assertTrue(solution.hasValidPath(arrayOf(intArrayOf(1))))
    }

    @Test
    fun testSingleRowPath() {
        assertTrue(solution.hasValidPath(arrayOf(intArrayOf(1, 1, 1, 1))))
    }
}
