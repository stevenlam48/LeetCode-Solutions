package sumofweightedmodesinsubarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfWeightedModesInSubarraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(25L, solution.modeWeight(intArrayOf(1, 1, 2, 2, 3, 3, 3), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(3L, solution.modeWeight(intArrayOf(1, 2, 3, 4, 5, 6), 5))
    }

    @Test
    fun testWindowOfOne() {
        assertEquals(10L, solution.modeWeight(intArrayOf(4, 2, 4), 1))
    }

    @Test
    fun testSingleElement() {
        assertEquals(7L, solution.modeWeight(intArrayOf(7), 1))
    }

    @Test
    fun testTieBreaksToSmallerValue() {
        assertEquals(1L + 2L, solution.modeWeight(intArrayOf(2, 1, 2, 1), 2))
    }
}
