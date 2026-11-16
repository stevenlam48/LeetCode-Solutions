package minimumdifficultyofajobschedule
// Time:  O(d * n^2)
// Space: O(d * n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDifficultyOfAJobScheduleTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(7, solution.minDifficulty(intArrayOf(6, 5, 4, 3, 2, 1), 2))
        assertEquals(-1, solution.minDifficulty(intArrayOf(9, 9, 9), 4))
        assertEquals(3, solution.minDifficulty(intArrayOf(1, 1, 1), 3))
    }

    @Test
    fun oneDayTakesMaximumDifficulty() {
        assertEquals(9, solution.minDifficulty(intArrayOf(3, 9, 2, 5), 1))
    }

    @Test
    fun eachJobOnItsOwnDay() {
        assertEquals(15, solution.minDifficulty(intArrayOf(1, 2, 3, 4, 5), 5))
    }
}
