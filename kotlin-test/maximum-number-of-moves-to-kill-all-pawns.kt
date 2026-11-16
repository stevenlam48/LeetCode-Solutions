package maximumnumberofmovestokillallpawns

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfMovesToKillAllPawnsTest {
    private val solution = Solution()

    @Test
    fun pawnStartsUnderKnight() {
        assertEquals(0, solution.maxMoves(0, 0, arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun pawnIsOneMoveAway() {
        assertEquals(1, solution.maxMoves(0, 0, arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun diagonalNeighborNeedsFourMoves() {
        assertEquals(4, solution.maxMoves(1, 1, arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun twoSymmetricPawns() {
        val positions = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1))
        assertEquals(3, solution.maxMoves(0, 0, positions))
    }

    @Test
    fun duplicatePawnPositions() {
        val positions = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2))
        assertEquals(1, solution.maxMoves(0, 0, positions))
    }
}
