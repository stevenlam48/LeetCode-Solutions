package partitionequalsubsetsum

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PartitionEqualSubsetSumTest {
    private val solution = Solution()

    @Test
    fun findsEqualPartition() {
        assertTrue(solution.canPartition(intArrayOf(1, 5, 11, 5)))
    }

    @Test
    fun rejectsOddTotal() {
        assertFalse(solution.canPartition(intArrayOf(1, 2, 3, 5)))
    }

    @Test
    fun rejectsEvenTotalWithoutEqualSubset() {
        assertFalse(solution.canPartition(intArrayOf(2, 2, 3, 5)))
    }

    @Test
    fun rejectsSinglePositiveElement() {
        assertFalse(solution.canPartition(intArrayOf(100)))
    }
}
