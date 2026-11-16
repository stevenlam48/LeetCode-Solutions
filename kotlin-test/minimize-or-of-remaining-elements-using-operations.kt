package minimizeorofremainingelementsusingoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeOrOfRemainingElementsUsingOperationsTest {
    @Test
    fun noOperationsKeepsOrOfAllValues() {
        assertEquals(7, Solution().minOrAfterOperations(intArrayOf(1, 2, 4), 0))
    }

    @Test
    fun enoughOperationsCanClearEveryBit() {
        assertEquals(0, Solution().minOrAfterOperations(intArrayOf(1, 2, 4), 2))
    }

    @Test
    fun oneOperationSelectsBestAdjacentPair() {
        assertEquals(8, Solution().minOrAfterOperations(intArrayOf(12, 10, 8), 1))
    }

    @Test
    fun allZeroValues() {
        assertEquals(0, Solution().minOrAfterOperations(intArrayOf(0, 0, 0), 1))
    }

    @Test
    fun singleValueWithoutOperations() {
        assertEquals(9, Solution().minOrAfterOperations(intArrayOf(9), 0))
    }
}
