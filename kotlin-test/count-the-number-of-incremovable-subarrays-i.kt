package countthenumberofincremovablesubarraysi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfIncremovableSubarraysITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10L, solution.incremovableSubarrayCount(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(7L, solution.incremovableSubarrayCount(intArrayOf(6, 5, 7, 8)))
    }

    @Test
    fun testExample3() {
        assertEquals(3L, solution.incremovableSubarrayCount(intArrayOf(8, 7, 6, 6)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1L, solution.incremovableSubarrayCount(intArrayOf(1)))
    }

    @Test
    fun testDecreasingPair() {
        assertEquals(3L, solution.incremovableSubarrayCount(intArrayOf(2, 1)))
    }
}
