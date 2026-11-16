package minimummovestogetapeacefulboard

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToGetAPeacefulBoardTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.minMoves(
            arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(1, 1))
        ))
    }

    @Test
    fun testTwoRooks() {
        assertEquals(1, solution.minMoves(
            arrayOf(intArrayOf(0, 0), intArrayOf(0, 1))
        ))
    }

    @Test
    fun testAlreadyPeaceful() {
        assertEquals(0, solution.minMoves(
            arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 2))
        ))
    }

    @Test
    fun testSameRow() {
        assertEquals(3, solution.minMoves(
            arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(0, 2))
        ))
    }

    @Test
    fun testSingleRook() {
        assertEquals(0, solution.minMoves(arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun testMixedDuplicates() {
        assertEquals(2, solution.minMoves(
            arrayOf(intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 1))
        ))
    }
}
