package minimumoperationstoreducextozero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToReduceXToZeroTest {
    @Test
    fun example() {
        assertEquals(2, Solution().minOperations(intArrayOf(1, 1, 4, 2, 3), 5))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().minOperations(intArrayOf(5, 6, 7, 8, 9), 4))
        assertEquals(-1, Solution().minOperations(intArrayOf(1, 1), 3))
    }

    @Test
    fun removeOneSide() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 1), 1))
    }

    @Test
    fun wholeArray() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 2, 3), 6))
    }
}
