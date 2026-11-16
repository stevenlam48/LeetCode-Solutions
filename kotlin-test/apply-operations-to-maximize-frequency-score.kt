package applyoperationstomaximizefrequencyscore

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyOperationsToMaximizeFrequencyScoreTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.maxFrequencyScore(intArrayOf(1, 2, 6, 4), 3))
    }

    @Test
    fun fourValuesCanShareAFrequency() {
        assertEquals(4, solution.maxFrequencyScore(intArrayOf(1, 4, 4, 2, 6), 5))
    }

    @Test
    fun noBudgetWithDistinctValues() {
        assertEquals(1, solution.maxFrequencyScore(intArrayOf(3, 1, 2), 0))
    }

    @Test
    fun duplicateValuesNeedNoOperations() {
        assertEquals(4, solution.maxFrequencyScore(intArrayOf(5, 5, 5, 5), 0))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.maxFrequencyScore(IntArray(0), 10))
    }
}
