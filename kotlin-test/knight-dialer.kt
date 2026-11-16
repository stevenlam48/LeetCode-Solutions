package knightdialer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KnightDialerTest {
    private val solution = Solution()

    @Test
    fun oneDigit() {
        assertEquals(10, solution.knightDialer(1))
    }

    @Test
    fun twoDigits() {
        assertEquals(20, solution.knightDialer(2))
    }

    @Test
    fun threeDigits() {
        assertEquals(46, solution.knightDialer(3))
    }

    @Test
    fun fourDigits() {
        assertEquals(104, solution.knightDialer(4))
    }

    @Test
    fun fiveDigits() {
        assertEquals(240, solution.knightDialer(5))
    }

    @Test
    fun largeInput() {
        assertEquals(136006598, solution.knightDialer(3131))
    }
}
