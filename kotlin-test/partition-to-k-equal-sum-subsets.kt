package partitiontokequalsumsubsets

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PartitionToKEqualSumSubsetsTest {
    private val solution = Solution()

    @Test
    fun findsFourEqualSubsets() {
        assertTrue(solution.canPartitionKSubsets(intArrayOf(4, 3, 2, 3, 5, 2, 1), 4))
    }

    @Test
    fun rejectsInvalidTotal() {
        assertFalse(solution.canPartitionKSubsets(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun handlesRepeatedSingleValueSubsets() {
        assertTrue(solution.canPartitionKSubsets(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun rejectsElementExceedingTarget() {
        assertFalse(solution.canPartitionKSubsets(intArrayOf(2, 2, 2, 2, 6), 3))
    }
}
