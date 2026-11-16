package minimummovestoreachtargetingrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumMovesToReachTargetInGridTest {
    private val solution = Solution()

    @Test
    fun alreadyAtTarget() {
        assertEquals(0, solution.minMoves(1, 2, 1, 2))
    }

    @Test
    fun reversesAdditionMoves() {
        assertEquals(2, solution.minMoves(1, 2, 3, 5))
    }

    @Test
    fun reversesDoublingMoves() {
        assertEquals(2, solution.minMoves(2, 3, 2, 12))
    }

    @Test
    fun rejectsTargetBehindStart() {
        assertEquals(-1, solution.minMoves(4, 3, 2, 10))
    }

    @Test
    fun rejectsUnreachableEqualCoordinates() {
        assertEquals(-1, solution.minMoves(1, 2, 2, 2))
    }
}
