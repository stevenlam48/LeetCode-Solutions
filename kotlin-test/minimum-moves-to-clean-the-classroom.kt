package minimummovestocleantheclassroom

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToCleanTheClassroomTest {

    private val solution = Solution()

    @Test
    fun testNoLitter() {
        assertEquals(0, solution.minMoves(arrayOf("S..", "..."), 10))
    }

    @Test
    fun testAdjacentLitter() {
        assertEquals(1, solution.minMoves(arrayOf("SL"), 1))
    }

    @Test
    fun testNotEnoughEnergy() {
        assertEquals(-1, solution.minMoves(arrayOf("SL"), 0))
    }

    @Test
    fun testTwoSteps() {
        assertEquals(2, solution.minMoves(arrayOf("S.L"), 3))
    }

    @Test
    fun testRechargeTile() {
        assertEquals(3, solution.minMoves(arrayOf("S.RL"), 2))
    }

    @Test
    fun testBlockedLitter() {
        assertEquals(-1, solution.minMoves(arrayOf("S", "X", "L"), 5))
    }
}
