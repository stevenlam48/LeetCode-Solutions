package minimumnumberofincreasingsubsequencetoberemoved

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfIncreasingSubsequenceToBeRemovedTest {
    private val solution = Solution()

    @Test
    fun allDecreasing() {
        assertEquals(5, solution.minOperations(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun allIncreasing() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun duplicatesAreNonIncreasing() {
        assertEquals(3, solution.minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun mixedArray() {
        assertEquals(2, solution.minOperations(intArrayOf(2, 1, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.minOperations(intArrayOf(7)))
    }
}
