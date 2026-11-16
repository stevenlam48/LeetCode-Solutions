package findthewinningplayerincoingame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheWinningPlayerInCoinGameTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("Alice", solution.losingPlayer(2, 7))
    }

    @Test
    fun testExample2() {
        assertEquals("Bob", solution.losingPlayer(4, 11))
    }

    @Test
    fun testInsufficientCoins() {
        assertEquals("Bob", solution.losingPlayer(0, 3))
        assertEquals("Bob", solution.losingPlayer(5, 3))
    }

    @Test
    fun testOddTurns() {
        assertEquals("Alice", solution.losingPlayer(1, 4))
        assertEquals("Alice", solution.losingPlayer(3, 12))
    }

    @Test
    fun testEvenTurns() {
        assertEquals("Bob", solution.losingPlayer(2, 8))
        assertEquals("Bob", solution.losingPlayer(10, 40))
    }
}
