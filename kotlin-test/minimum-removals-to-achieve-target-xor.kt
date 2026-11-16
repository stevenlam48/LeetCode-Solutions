package minimumremovalstoachievetargetxor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRemovalsToAchieveTargetXorTest {
    @Test
    fun oneRemoval() {
        assertEquals(1, Solution().minRemovals(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun noRemovalNeeded() {
        assertEquals(0, Solution().minRemovals(intArrayOf(1, 1, 1), 1))
        assertEquals(0, Solution().minRemovals(intArrayOf(1, 2, 4), 7))
    }

    @Test
    fun removeEverything() {
        assertEquals(3, Solution().minRemovals(intArrayOf(1, 2, 4), 0))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().minRemovals(intArrayOf(2), 5))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minRemovals(intArrayOf(2), 2))
    }
}
