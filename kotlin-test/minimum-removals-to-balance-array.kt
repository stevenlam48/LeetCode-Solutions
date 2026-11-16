package minimumremovalstobalancearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRemovalsToBalanceArrayTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minRemoval(intArrayOf(1, 6, 2, 9), 3))
    }

    @Test
    fun alreadyBalanced() {
        assertEquals(0, Solution().minRemoval(intArrayOf(2, 1, 2), 2))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minRemoval(intArrayOf(1), 5))
    }

    @Test
    fun needOneRemoval() {
        assertEquals(1, Solution().minRemoval(intArrayOf(1, 2), 1))
        assertEquals(1, Solution().minRemoval(intArrayOf(4, 6), 1))
    }

    @Test
    fun duplicates() {
        assertEquals(0, Solution().minRemoval(intArrayOf(5, 5, 5), 1))
    }
}
