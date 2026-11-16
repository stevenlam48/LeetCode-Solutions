package numberofsubarrayswithoddsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubArraysWithOddSumTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4, solution.numOfSubarrays(intArrayOf(1, 3, 5)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(0, solution.numOfSubarrays(intArrayOf(2, 4, 6)))
    }

    @Test
    fun exampleThree() {
        assertEquals(16, solution.numOfSubarrays(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun emptyAndNegativeValues() {
        assertEquals(0, solution.numOfSubarrays(intArrayOf()))
        assertEquals(4, solution.numOfSubarrays(intArrayOf(-1, -2, -3)))
    }
}
