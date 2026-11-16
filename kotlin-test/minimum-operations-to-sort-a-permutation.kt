package minimumoperationstosortapermutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToSortAPermutationTest {
    @Test
    fun alreadySorted() {
        assertEquals(0, Solution().minOperations(intArrayOf(0, 1, 2, 3)))
    }

    @Test
    fun rotateOnce() {
        assertEquals(1, Solution().minOperations(intArrayOf(3, 0, 1, 2)))
    }

    @Test
    fun reverseDirection() {
        assertEquals(2, Solution().minOperations(intArrayOf(0, 2, 1)))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().minOperations(intArrayOf(0, 3, 1, 2)))
    }
}
