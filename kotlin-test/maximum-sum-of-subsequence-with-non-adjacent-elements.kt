package maximumsumofsubsequencewithnonadjacentelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfSubsequenceWithNonAdjacentElementsTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            21,
            solution.maximumSumSubsequence(
                intArrayOf(3, 5, 9),
                arrayOf(intArrayOf(1, -2), intArrayOf(0, -3))
            )
        )
    }

    @Test
    fun twoElements() {
        assertEquals(0, solution.maximumSumSubsequence(intArrayOf(0, -1), arrayOf(intArrayOf(0, -5))))
    }

    @Test
    fun updateCreatesLargerValue() {
        assertEquals(9, solution.maximumSumSubsequence(intArrayOf(1, 2, 3, 4), arrayOf(intArrayOf(0, 5))))
    }

    @Test
    fun allNegativeValues() {
        assertEquals(0, solution.maximumSumSubsequence(intArrayOf(-1, -2, -3), arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun singleElement() {
        assertEquals(7, solution.maximumSumSubsequence(intArrayOf(7), arrayOf(intArrayOf(0, 7))))
    }
}
