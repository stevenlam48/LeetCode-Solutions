package minimumunlockedindicestosortnums

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumUnlockedIndicesToSortNumsTest {
    private val solution = Solution()

    @Test
    fun testAlreadySorted() {
        assertEquals(0, solution.minUnlockedIndices(intArrayOf(1, 2, 3), intArrayOf(0, 0, 0)))
    }

    @Test
    fun testOneSwapLocked() {
        assertEquals(1, solution.minUnlockedIndices(intArrayOf(2, 1, 3), intArrayOf(1, 0, 0)))
    }

    @Test
    fun testOneSwapUnlocked() {
        assertEquals(0, solution.minUnlockedIndices(intArrayOf(1, 3, 2), intArrayOf(0, 0, 0)))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, solution.minUnlockedIndices(intArrayOf(3, 1, 2), intArrayOf(0, 0, 0)))
    }

    @Test
    fun testAllLockedSorted() {
        assertEquals(0, solution.minUnlockedIndices(intArrayOf(1, 2, 3), intArrayOf(1, 1, 1)))
    }
}
