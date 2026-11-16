package lastmomentbeforeallantsfalloutofaplank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LastMomentBeforeAllAntsFallOutOfAPlankTest {
    private val solution = Solution()

    @Test
    fun findsLastMomentWithAntsMovingBothWays() {
        assertEquals(4, solution.getLastMoment(4, intArrayOf(4, 3), intArrayOf(0, 1)))
    }

    @Test
    fun findsLastMomentWithOnlyRightMovingAnts() {
        assertEquals(7, solution.getLastMoment(7, intArrayOf(), intArrayOf(0, 1, 2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun findsLastMomentWithOnlyLeftMovingAnts() {
        assertEquals(7, solution.getLastMoment(7, intArrayOf(0, 1, 2, 3, 4, 5, 6, 7), intArrayOf()))
    }

    @Test
    fun returnsZeroWithoutAnts() {
        assertEquals(0, solution.getLastMoment(4, intArrayOf(), intArrayOf()))
    }
}
