package chalkboardxorgam

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ChalkboardXorGamTest {
    private val solution = Solution()

    @Test
    fun nonzeroXorWithOddCountLoses() {
        assertFalse(solution.xorGame(intArrayOf(1, 1, 2)))
    }

    @Test
    fun evenCountWins() {
        assertTrue(solution.xorGame(intArrayOf(1, 2)))
    }

    @Test
    fun zeroXorWins() {
        assertTrue(solution.xorGame(intArrayOf(1, 2, 3)))
    }

    @Test
    fun zeroValueWins() {
        assertTrue(solution.xorGame(intArrayOf(0)))
    }
}
