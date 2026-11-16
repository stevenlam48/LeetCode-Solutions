package maxsumofapairwithequalsumofdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxSumOfAPairWithEqualSumOfDigitsTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        assertEquals(54, solution.maximumSum(intArrayOf(18, 43, 36, 13, 7)))
    }

    @Test
    fun computesSecondExample() {
        assertEquals(-1, solution.maximumSum(intArrayOf(10, 12, 19, 14)))
    }

    @Test
    fun keepsLargestValueForFuturePairs() {
        assertEquals(128, solution.maximumSum(intArrayOf(55, 19, 73, 46)))
    }

    @Test
    fun pairsDuplicateValues() {
        assertEquals(44, solution.maximumSum(intArrayOf(22, 22)))
    }

    @Test
    fun groupsZeroByDigitSumZero() {
        assertEquals(0, solution.maximumSum(intArrayOf(0, 0)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(-1, solution.maximumSum(intArrayOf()))
    }
}
