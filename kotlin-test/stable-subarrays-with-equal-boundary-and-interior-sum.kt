package stablesubarrayswithequalboundaryandinteriorsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StableSubarraysWithEqualBoundaryAndInteriorSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2L, solution.countStableSubarrays(intArrayOf(9, 3, 3, 3, 9)))
    }

    @Test
    fun testNoStableSubarray() {
        assertEquals(0L, solution.countStableSubarrays(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testAllZeros() {
        assertEquals(1L, solution.countStableSubarrays(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.countStableSubarrays(intArrayOf(5)))
    }

    @Test
    fun testRepeatedOnes() {
        assertEquals(2L, solution.countStableSubarrays(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testEqualTriple() {
        assertEquals(1L, solution.countStableSubarrays(intArrayOf(3, 3, 3)))
    }
}
