package minimumoperationstomakexorofallelementszero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeXorOfAllElementsZeroTest {
    @Test
    fun alreadyZeroXor() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 3)))
        assertEquals(0, Solution().minOperations(intArrayOf(1, 1)))
    }

    @Test
    fun singleXorOperation() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 1, 2)))
    }

    @Test
    fun twoXorOperations() {
        assertEquals(2, Solution().minOperations(intArrayOf(1, 2, 4, 4)))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().minOperations(intArrayOf(1, 2)))
        assertEquals(-1, Solution().minOperations(intArrayOf(1, 1, 1)))
    }
}
