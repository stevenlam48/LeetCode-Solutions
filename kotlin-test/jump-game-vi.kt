package jumpgamevi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameViTest {
    @Test
    fun `chooses best scores within window`() {
        assertEquals(7, Solution().maxResult(intArrayOf(1, -1, -2, 4, -7, 3), 2))
    }

    @Test
    fun `skips negative scores when possible`() {
        assertEquals(17, Solution().maxResult(intArrayOf(10, -5, -2, 4, 0, 3), 3))
    }

    @Test
    fun `handles larger negative detour`() {
        assertEquals(0, Solution().maxResult(intArrayOf(1, -5, -20, 4, -1, 3, -6, -3), 2))
    }

    @Test
    fun `single negative element`() {
        assertEquals(-4, Solution().maxResult(intArrayOf(-4), 1))
    }
}
