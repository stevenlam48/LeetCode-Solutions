package minimumswapstoavoidforbiddenvalues

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToAvoidForbiddenValuesTest {
    private val solution = Solution()

    @Test
    fun testAllConflicts() {
        assertEquals(2, solution.minSwaps(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, solution.minSwaps(intArrayOf(1, 2, 1), intArrayOf(1, 1, 2)))
        assertEquals(-1, solution.minSwaps(intArrayOf(1, 1, 2), intArrayOf(1, 1, 2)))
    }

    @Test
    fun testNoConflicts() {
        assertEquals(0, solution.minSwaps(intArrayOf(2, 1, 2), intArrayOf(1, 2, 1)))
        assertEquals(0, solution.minSwaps(intArrayOf(1, 2, 3, 4), intArrayOf(2, 1, 4, 3)))
    }

    @Test
    fun testPartialConflicts() {
        assertEquals(1, solution.minSwaps(intArrayOf(1, 1, 2, 2), intArrayOf(1, 2, 1, 2)))
        assertEquals(1, solution.minSwaps(intArrayOf(5, 5, 6), intArrayOf(5, 6, 6)))
    }
}
