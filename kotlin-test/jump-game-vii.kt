package jumpgamevii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JumpGameViiTest {
    @Test
    fun `can reach end using allowed jump lengths`() {
        assertTrue(Solution().canReach("011010", 2, 3))
    }

    @Test
    fun `blocked positions make end unreachable`() {
        assertFalse(Solution().canReach("01101110", 2, 3))
    }

    @Test
    fun `single zero is already reachable`() {
        assertTrue(Solution().canReach("0", 1, 1))
    }

    @Test
    fun `adjacent zeros with unit jumps`() {
        assertTrue(Solution().canReach("000", 1, 1))
    }

    @Test
    fun `single blocked position prevents progress`() {
        assertFalse(Solution().canReach("010", 1, 1))
    }
}
