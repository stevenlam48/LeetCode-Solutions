package stonegameiv

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneGameIVTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.winnerSquareGame(1))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.winnerSquareGame(2))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.winnerSquareGame(4))
    }

    @Test
    fun testExample4() {
        assertFalse(solution.winnerSquareGame(7))
    }

    @Test
    fun testLarger() {
        assertTrue(solution.winnerSquareGame(18))
        assertFalse(solution.winnerSquareGame(17))
    }
}
