package removecoloredpiecesifbothneighborsarethesamecolor

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveColoredPiecesIfBothNeighborsAreTheSameColorTest {
    @Test
    fun equalMoveCounts() {
        assertFalse(Solution().winnerOfGame("AAABBB"))
    }

    @Test
    fun tooFewCharacters() {
        assertFalse(Solution().winnerOfGame("AA"))
    }

    @Test
    fun aliceHasMoreMoves() {
        assertTrue(Solution().winnerOfGame("AAABABB"))
    }

    @Test
    fun bobHasMoreMoves() {
        assertFalse(Solution().winnerOfGame("ABBBBBBBAA"))
    }

    @Test
    fun alternatingColors() {
        assertFalse(Solution().winnerOfGame("ABABAB"))
    }
}
