package minimumdifferencebetweenhighestandlowestofkscores
// Time:  O(nlogn)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDifferenceBetweenHighestAndLowestOfKScoresTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(0, solution.minimumDifference(intArrayOf(90), 1))
        assertEquals(2, solution.minimumDifference(intArrayOf(9, 4, 1, 7), 2))
    }

    @Test
    fun selectAllScores() {
        assertEquals(990, solution.minimumDifference(intArrayOf(10, 100, 300, 200, 1000, 20, 30), 7))
    }

    @Test
    fun bestWindowAndDuplicateScores() {
        assertEquals(20, solution.minimumDifference(intArrayOf(10, 100, 300, 200, 1000, 20, 30), 3))
        assertEquals(0, solution.minimumDifference(intArrayOf(5, 5, 5, 9), 3))
    }
}
