package visitarraypositionstomaximizescore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VisitArrayPositionsToMaximizeScoreTest {
    private val solution = Solution()

    @Test
    fun maximizesScoreWithParityChanges() {
        assertEquals(18L, solution.maxScore(intArrayOf(2, 3, 6, 10), 6))
    }

    @Test
    fun keepsSameParityWithoutPenalty() {
        assertEquals(9L, solution.maxScore(intArrayOf(1, 3, 5), 1))
        assertEquals(20L, solution.maxScore(intArrayOf(2, 4, 6, 8), 3))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(7L, solution.maxScore(intArrayOf(7), 5))
    }

    @Test
    fun usesLongAccumulator() {
        assertEquals(
            4_294_967_292L,
            solution.maxScore(intArrayOf(2_147_483_646, 2_147_483_646), 0)
        )
    }
}
