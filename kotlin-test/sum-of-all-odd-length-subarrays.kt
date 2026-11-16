package sumofalloddlengthsubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfAllOddLengthSubarraysTest {
    @Test
    fun exampleOne() {
        assertEquals(58, Solution().sumOddLengthSubarrays(intArrayOf(1, 4, 2, 5, 3)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, Solution().sumOddLengthSubarrays(intArrayOf(1, 2)))
    }

    @Test
    fun exampleThree() {
        assertEquals(66, Solution().sumOddLengthSubarrays(intArrayOf(10, 11, 12)))
    }

    @Test
    fun singletonAndEmptyInput() {
        assertEquals(9, Solution().sumOddLengthSubarrays(intArrayOf(9)))
        assertEquals(0, Solution().sumOddLengthSubarrays(intArrayOf()))
    }
}
