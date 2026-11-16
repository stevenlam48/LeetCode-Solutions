package minimumoperationstoformsubsetsumi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToFormSubsetSumITest {

    @Test
    fun testSingleElementExact() {
        assertEquals(0, Solution().minOperations(intArrayOf(1), 1))
    }

    @Test
    fun testDoubleOnce() {
        assertEquals(1, Solution().minOperations(intArrayOf(1), 2))
    }

    @Test
    fun testDoubleTwice() {
        assertEquals(2, Solution().minOperations(intArrayOf(1), 4))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, Solution().minOperations(intArrayOf(1), 3))
        assertEquals(-1, Solution().minOperations(intArrayOf(3), 10))
    }

    @Test
    fun testHalve() {
        assertEquals(1, Solution().minOperations(intArrayOf(2, 3), 1))
    }

    @Test
    fun testExactSubset() {
        assertEquals(0, Solution().minOperations(intArrayOf(2, 3), 5))
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 3), 6))
    }

    @Test
    fun testMixedOperations() {
        assertEquals(2, Solution().minOperations(intArrayOf(2, 3), 10))
        assertEquals(3, Solution().minOperations(intArrayOf(2, 4, 8), 7))
    }
}
