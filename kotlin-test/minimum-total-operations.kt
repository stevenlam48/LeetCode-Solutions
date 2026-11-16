package minimumtotaloperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumTotalOperationsTest {
    private val solution = Solution()

    @Test
    fun testAlternating() {
        assertEquals(5, solution.minOperations(intArrayOf(1, 2, 1, 2, 1, 2)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(0, solution.minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minOperations(intArrayOf(7)))
    }

    @Test
    fun testTwoDifferent() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 2)))
    }

    @Test
    fun testTwoEqual() {
        assertEquals(0, solution.minOperations(intArrayOf(3, 3)))
    }
}
