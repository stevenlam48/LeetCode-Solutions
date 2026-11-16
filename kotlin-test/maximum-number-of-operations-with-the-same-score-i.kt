package maximumnumberofoperationswiththesamescorei

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfOperationsWithTheSameScoreITest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(2, solution.maxOperations(intArrayOf(3, 2, 1, 4, 5)))
    }

    @Test
    fun standardExampleWithOnlyOneOperation() {
        assertEquals(1, solution.maxOperations(intArrayOf(3, 2, 6, 1, 4)))
    }

    @Test
    fun exactlyOnePair() {
        assertEquals(1, solution.maxOperations(intArrayOf(1, 2)))
    }

    @Test
    fun allPairsHaveSameScore() {
        assertEquals(3, solution.maxOperations(intArrayOf(1, 4, 1, 4, 1, 4)))
    }

    @Test
    fun negativeScores() {
        assertEquals(2, solution.maxOperations(intArrayOf(-1, 2, -1, 2)))
    }
}
