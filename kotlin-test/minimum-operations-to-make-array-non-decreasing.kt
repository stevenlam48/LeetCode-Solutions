package minimumoperationstomakearraynondecreasing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayNonDecreasingTest {
    @Test
    fun testMultipleDrops() {
        assertEquals(6L, Solution().minOperations(intArrayOf(4, 2, 5, 1)))
    }

    @Test
    fun testAlreadyNonDecreasing() {
        assertEquals(0L, Solution().minOperations(intArrayOf(1, 1, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, Solution().minOperations(intArrayOf(7)))
    }

    @Test
    fun testNegativeValues() {
        assertEquals(2L, Solution().minOperations(intArrayOf(-1, -3, 0)))
    }
}
