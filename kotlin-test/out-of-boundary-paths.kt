package outofboundarypaths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OutOfBoundaryPathsTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(6, solution.findPaths(2, 2, 2, 0, 0))
        assertEquals(12, solution.findPaths(1, 3, 3, 0, 1))
    }

    @Test
    fun zeroMoves() {
        assertEquals(0, solution.findPaths(2, 2, 0, 0, 0))
    }

    @Test
    fun oneCell() {
        assertEquals(4, solution.findPaths(1, 1, 1, 0, 0))
        assertEquals(4, solution.findPaths(1, 1, 2, 0, 0))
    }
}
