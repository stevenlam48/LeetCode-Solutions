package minimumsumofsquareddifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSumOfSquaredDifferenceTest {
    @Test
    fun example1NoOperations() {
        assertEquals(
            579L,
            Solution().minSumSquareDiff(intArrayOf(1, 2, 3, 4), intArrayOf(2, 10, 20, 19), 0, 0)
        )
    }

    @Test
    fun example2TwoOperations() {
        assertEquals(
            43L,
            Solution().minSumSquareDiff(intArrayOf(1, 4, 10, 12), intArrayOf(5, 8, 6, 9), 1, 1)
        )
    }

    @Test
    fun allDifferencesEliminated() {
        assertEquals(0L, Solution().minSumSquareDiff(intArrayOf(1, 2), intArrayOf(3, 5), 2, 3))
    }

    @Test
    fun remainingOperationsDistributedEvenly() {
        assertEquals(18L, Solution().minSumSquareDiff(intArrayOf(0, 0), intArrayOf(5, 4), 1, 2))
    }

    @Test
    fun alreadyEqual() {
        assertEquals(0L, Solution().minSumSquareDiff(intArrayOf(5, 5), intArrayOf(5, 5), 0, 0))
    }
}
