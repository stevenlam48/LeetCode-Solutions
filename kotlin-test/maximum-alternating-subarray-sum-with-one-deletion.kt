package maximumalternatingsubarraysumwithonedeletion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAlternatingSubarraySumWithOneDeletionTest {
    private val solution = Solution()

    @Test
    fun deletionImprovesAlternatingSum() {
        assertEquals(7L, solution.maxAlternatingSum(intArrayOf(1, 5, 2, 3, 4)))
    }

    @Test
    fun alternatingRunWithoutDeletion() {
        assertEquals(9L, solution.maxAlternatingSum(intArrayOf(8, 1, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(-3L, solution.maxAlternatingSum(intArrayOf(-3)))
    }

    @Test
    fun negativeSubtrahendIncreasesSum() {
        assertEquals(8L, solution.maxAlternatingSum(intArrayOf(-4, 6, -2)))
    }

    @Test
    fun deletionCanRemoveFirstElement() {
        assertEquals(9L, solution.maxAlternatingSum(intArrayOf(2, 9, 1)))
    }
}
