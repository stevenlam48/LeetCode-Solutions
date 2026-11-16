package flipgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlipGameTest {
    private val solution = Solution()

    @Test
    fun generatesEveryMoveForOneRun() {
        assertEquals(
            listOf("--++", "+--+", "++--"),
            solution.generatePossibleNextMoves("++++")
        )
    }

    @Test
    fun generatesMovesInSeparateRuns() {
        assertEquals(
            listOf("------++", "--++----"),
            solution.generatePossibleNextMoves("--++--++")
        )
    }

    @Test
    fun returnsEmptyWhenNoMoveExists() {
        assertEquals(emptyList<String>(), solution.generatePossibleNextMoves(""))
        assertEquals(emptyList<String>(), solution.generatePossibleNextMoves("+"))
        assertEquals(emptyList<String>(), solution.generatePossibleNextMoves("--"))
    }

    @Test
    fun flipsTheOnlyAvailablePair() {
        assertEquals(listOf("--"), solution.generatePossibleNextMoves("++"))
    }
}
