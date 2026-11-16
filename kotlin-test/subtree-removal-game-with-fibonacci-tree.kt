package subtreeremovalgamewithfibonaccitree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubtreeRemovalGameWithFibonacciTreeTest {
    @Test
    fun losingPositions() {
        assertFalse(Solution().findGameWinner(1))
        assertFalse(Solution().findGameWinner(7))
        assertFalse(Solution().findGameWinner(13))
    }

    @Test
    fun winningPositions() {
        assertTrue(Solution().findGameWinner(2))
        assertTrue(Solution().findGameWinner(6))
        assertTrue(Solution().findGameWinner(12))
    }
}
