package minimumoperationstomaximizelastelementsinarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMaximizeLastElementsInArraysTest {
    @Test
    fun oneSwapNeeded() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 2), intArrayOf(2, 1)))
    }

    @Test
    fun alreadyValid() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().minOperations(intArrayOf(10, 1), intArrayOf(10, 1)))
    }

    @Test
    fun swapAll() {
        assertEquals(
            2,
            Solution().minOperations(intArrayOf(4, 3, 4, 3, 5), intArrayOf(3, 4, 3, 4, 3))
        )
    }
}
