package totalscoreofdungeonruns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalScoreOfDungeonRunsTest {
    @Test
    fun mixedRequirements() {
        assertEquals(5L, Solution().totalScore(10, intArrayOf(2, 3, 5), intArrayOf(5, 1, 1)))
    }

    @Test
    fun zeroRequirements() {
        assertEquals(5L, Solution().totalScore(5, intArrayOf(1, 2, 3), intArrayOf(0, 0, 0)))
    }

    @Test
    fun singleReachableRun() {
        assertEquals(1L, Solution().totalScore(10, intArrayOf(3), intArrayOf(5)))
    }

    @Test
    fun singleUnreachableRun() {
        assertEquals(0L, Solution().totalScore(1, intArrayOf(1), intArrayOf(1)))
    }
}
