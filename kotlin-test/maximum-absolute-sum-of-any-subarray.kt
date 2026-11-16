package maximumabsolutesumofanysubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAbsoluteSumOfAnySubarrayTest {
    private val solution = Solution()

    @Test
    fun mixedNumbers() {
        assertEquals(5, solution.maxAbsoluteSum(intArrayOf(1, -3, 2, 3, -4)))
    }

    @Test
    fun largestAbsoluteSumIsNegativeSubarray() {
        assertEquals(8, solution.maxAbsoluteSum(intArrayOf(2, -5, 1, -4, 3, -2)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.maxAbsoluteSum(intArrayOf()))
    }

    @Test
    fun singleNegativeNumber() {
        assertEquals(7, solution.maxAbsoluteSum(intArrayOf(-7)))
    }

    @Test
    fun trailingPositiveSegmentIsAnswer() {
        assertEquals(8, solution.maxAbsoluteSum(intArrayOf(3, 4, -2, 3)))
    }
}
