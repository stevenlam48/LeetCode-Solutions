package monotonicarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MonotonicArrayTest {
    private val solution = Solution()

    @Test
    fun acceptsIncreasingArray() {
        assertTrue(solution.isMonotonic(intArrayOf(1, 2, 2, 3)))
    }

    @Test
    fun acceptsDecreasingArray() {
        assertTrue(solution.isMonotonic(intArrayOf(6, 5, 4, 4)))
    }

    @Test
    fun rejectsArrayWithBothDirections() {
        assertFalse(solution.isMonotonic(intArrayOf(1, 3, 2)))
    }

    @Test
    fun acceptsEmptySingleAndConstantArrays() {
        assertTrue(solution.isMonotonic(intArrayOf()))
        assertTrue(solution.isMonotonic(intArrayOf(7)))
        assertTrue(solution.isMonotonic(intArrayOf(7, 7, 7)))
    }
}
