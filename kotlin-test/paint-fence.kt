package paintfence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaintFenceTest {
    private val solution = Solution()

    @Test
    fun smallFence() {
        assertEquals(0, solution.numWays(0, 3))
        assertEquals(3, solution.numWays(1, 3))
        assertEquals(9, solution.numWays(2, 3))
    }

    @Test
    fun examples() {
        assertEquals(6, solution.numWays(3, 2))
        assertEquals(24, solution.numWays(3, 3))
    }

    @Test
    fun oneColor() {
        assertEquals(1, solution.numWays(2, 1))
        assertEquals(0, solution.numWays(3, 1))
    }
}
