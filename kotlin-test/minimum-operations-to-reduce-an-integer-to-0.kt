package minimumoperationstoreduceanintegerto0

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToReduceAnIntegerTo0Test {
    @Test
    fun example() {
        assertEquals(2, Solution().minOperations(3))
        assertEquals(2, Solution().minOperations(6))
    }

    @Test
    fun smallValues() {
        assertEquals(0, Solution().minOperations(0))
        assertEquals(1, Solution().minOperations(1))
        assertEquals(1, Solution().minOperations(2))
    }

    @Test
    fun powersOfTwo() {
        assertEquals(1, Solution().minOperations(8))
        assertEquals(1, Solution().minOperations(16))
    }
}
