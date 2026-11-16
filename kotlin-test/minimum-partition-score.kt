package minimumpartitionscore

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MinimumPartitionScoreTest {
    private val solution = Solution()

    @Test
    fun keepsSingleElementInOnePartition() {
        assertEquals(15L, solution.minPartitionScore(intArrayOf(5), 1))
    }

    @Test
    fun scoresOnePartitionUsingTriangularSum() {
        assertEquals(21L, solution.minPartitionScore(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun selectsBalancedTwoWayPartition() {
        assertEquals(13L, solution.minPartitionScore(intArrayOf(1, 3, 2), 2))
    }

    @Test
    fun givesScoreOfEachSingletonWhenPartitionsEqualLength() {
        assertEquals(10L, solution.minPartitionScore(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun handlesZeroValuesAndEqualSums() {
        assertEquals(0L, solution.minPartitionScore(intArrayOf(0, 0, 0), 2))
        assertEquals(20L, solution.minPartitionScore(intArrayOf(2, 2, 2, 2), 2))
    }
}
