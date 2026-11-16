package nimgame

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NimGameTest {
    @Test
    fun `loses with four stones`() {
        assertFalse(Solution().canWinNim(4))
    }

    @Test
    fun `wins when stones are not divisible by four`() {
        assertTrue(Solution().canWinNim(1))
        assertTrue(Solution().canWinNim(2))
        assertTrue(Solution().canWinNim(3))
        assertTrue(Solution().canWinNim(7))
    }

    @Test
    fun `loses on larger multiples of four`() {
        assertFalse(Solution().canWinNim(8))
        assertFalse(Solution().canWinNim(40))
    }
}
