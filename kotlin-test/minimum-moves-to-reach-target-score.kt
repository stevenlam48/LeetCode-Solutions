package minimummovestoreachtargetscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumMovesToReachTargetScoreTest {
    private val solution = Solution()

    @Test
    fun targetOneNeedsNoMoves() {
        assertEquals(0, solution.minMoves(1, 3))
    }

    @Test
    fun incrementsOnlyWithoutDoubles() {
        assertEquals(4, solution.minMoves(5, 0))
    }

    @Test
    fun exhaustsAvailableDoubles() {
        assertEquals(7, solution.minMoves(19, 2))
    }

    @Test
    fun leavesUnusedDoubles() {
        assertEquals(4, solution.minMoves(10, 4))
    }
}
