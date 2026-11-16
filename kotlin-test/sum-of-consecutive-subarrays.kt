package sumofconsecutivesubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfConsecutiveSubarraysTest {
    @Test
    fun increasingArray() {
        assertEquals(20, Solution().getSum(intArrayOf(1, 2, 3)))
    }

    @Test
    fun decreasingArray() {
        assertEquals(20, Solution().getSum(intArrayOf(3, 2, 1)))
    }

    @Test
    fun brokenRuns() {
        assertEquals(11, Solution().getSum(intArrayOf(1, 3, 2)))
    }

    @Test
    fun shortArrays() {
        assertEquals(10, Solution().getSum(intArrayOf(2, 3)))
        assertEquals(1, Solution().getSum(intArrayOf(1)))
        assertEquals(0, Solution().getSum(intArrayOf()))
    }
}
