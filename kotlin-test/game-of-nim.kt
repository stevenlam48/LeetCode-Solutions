package gameofnim

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GameOfNimTest {
    @Test
    fun twoEqualPiles() {
        assertFalse(Solution().nimGame(intArrayOf(1, 1)))
    }

    @Test
    fun oneTwoThree() {
        assertFalse(Solution().nimGame(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singlePile() {
        assertTrue(Solution().nimGame(intArrayOf(1)))
    }

    @Test
    fun threeEqualPiles() {
        assertTrue(Solution().nimGame(intArrayOf(1, 1, 1)))
    }

    @Test
    fun fourEqualPiles() {
        assertFalse(Solution().nimGame(intArrayOf(2, 2, 2, 2)))
    }

    @Test
    fun nonzeroFirstPlayerWins() {
        assertTrue(Solution().nimGame(intArrayOf(3, 4, 5)))
    }
}
