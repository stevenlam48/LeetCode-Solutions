package maximumelementafterdecreasingandrearranging

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumElementAfterDecreasingAndRearrangingTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maximumElementAfterDecrementingAndRearranging(intArrayOf(2, 2, 1, 2, 1)))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().maximumElementAfterDecrementingAndRearranging(intArrayOf(100, 1, 1000)))
    }

    @Test
    fun example3() {
        assertEquals(5, Solution().maximumElementAfterDecrementingAndRearranging(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maximumElementAfterDecrementingAndRearranging(intArrayOf(7)))
    }

    @Test
    fun allEqual() {
        assertEquals(3, Solution().maximumElementAfterDecrementingAndRearranging(intArrayOf(3, 3, 3, 3)))
    }
}
