package caniwin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanIWinTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertFalse(solution.canIWin(10, 11))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.canIWin(10, 0))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.canIWin(10, 1))
    }

    @Test
    fun testSmallGame() {
        assertTrue(solution.canIWin(4, 6))
    }

    @Test
    fun testTotalExceedsSum() {
        assertFalse(solution.canIWin(5, 50))
    }
}
