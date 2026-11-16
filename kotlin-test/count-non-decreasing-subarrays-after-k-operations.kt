package countnondecreasingsubarraysafterkoperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNonDecreasingSubarraysAfterKOperationsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(17L, solution.countNonDecreasingSubarrays(intArrayOf(6, 3, 1, 2, 4, 4), 7))
    }

    @Test
    fun testAlreadyNonDecreasing() {
        assertEquals(6L, solution.countNonDecreasingSubarrays(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun testOneOperation() {
        assertEquals(4L, solution.countNonDecreasingSubarrays(intArrayOf(3, 1, 2), 1))
    }

    @Test
    fun testDescending() {
        assertEquals(15L, solution.countNonDecreasingSubarrays(intArrayOf(5, 4, 3, 2, 1), 10))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1L, solution.countNonDecreasingSubarrays(intArrayOf(1), 0))
    }

    @Test
    fun testEqualElements() {
        assertEquals(6L, solution.countNonDecreasingSubarrays(intArrayOf(2, 2, 2), 0))
    }
}
