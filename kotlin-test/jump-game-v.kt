package jumpgamev

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameVTest {
    @Test
    fun `leetcode mixed heights example`() {
        assertEquals(4, Solution().maxJumps(intArrayOf(6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12), 2))
    }

    @Test
    fun `equal heights cannot be revisited`() {
        assertEquals(1, Solution().maxJumps(intArrayOf(3, 3, 3, 3, 3), 3))
    }

    @Test
    fun `equal peaks cannot be jumped between through a valley`() {
        assertEquals(2, Solution().maxJumps(intArrayOf(7, 6, 7, 6, 7), 1))
    }

    @Test
    fun `large valleys also stop the path`() {
        assertEquals(2, Solution().maxJumps(intArrayOf(7, 1, 7, 1, 7), 1))
    }

    @Test
    fun `single element`() {
        assertEquals(1, Solution().maxJumps(intArrayOf(1), 1))
    }
}
