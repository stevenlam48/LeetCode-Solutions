package jumpgameiii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JumpGameIiiTest {
    @Test
    fun `reaches zero by jumping left`() {
        assertTrue(Solution().canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
    }

    @Test
    fun `reaches zero from either side`() {
        assertTrue(Solution().canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 0))
    }

    @Test
    fun `cannot reach zero`() {
        assertFalse(Solution().canReach(intArrayOf(3, 0, 2, 1, 2), 2))
    }

    @Test
    fun `already at zero`() {
        assertTrue(Solution().canReach(intArrayOf(0), 0))
    }
}
