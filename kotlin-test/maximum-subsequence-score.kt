package maximumsubsequencescore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubsequenceScoreTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(12L, solution.maxScore(intArrayOf(1, 3, 3, 2), intArrayOf(2, 1, 3, 4), 3))
    }

    @Test
    fun secondExample() {
        assertEquals(30L, solution.maxScore(intArrayOf(4, 2, 3, 1, 1), intArrayOf(7, 5, 10, 9, 1), 1))
    }

    @Test
    fun repeatedScoresCanShareTheMinimum() {
        assertEquals(18L, solution.maxScore(intArrayOf(4, 5, 3), intArrayOf(2, 2, 1), 2))
    }

    @Test
    fun entireArrayIsRequired() {
        assertEquals(15L, solution.maxScore(intArrayOf(5, 4, 3, 2, 1), intArrayOf(5, 4, 3, 2, 1), 5))
    }
}
