package jumpgameviii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameViiiTest {
    @Test
    fun `leetcode mixed direction example`() {
        assertEquals(8L, Solution().minCost(intArrayOf(3, 2, 4, 4, 1), intArrayOf(3, 7, 6, 4, 2)))
    }

    @Test
    fun `strictly increasing values`() {
        assertEquals(2L, Solution().minCost(intArrayOf(0, 1, 2), intArrayOf(1, 1, 1)))
    }

    @Test
    fun `equal values retain only the nearest useful predecessor`() {
        assertEquals(5L, Solution().minCost(intArrayOf(1, 1, 1), intArrayOf(1, 2, 3)))
    }

    @Test
    fun `direct jump is cheaper than valley detour`() {
        assertEquals(1L, Solution().minCost(intArrayOf(2, 1, 2), intArrayOf(1, 10, 1)))
    }

    @Test
    fun `single element costs nothing`() {
        assertEquals(0L, Solution().minCost(intArrayOf(5), intArrayOf(9)))
    }
}
