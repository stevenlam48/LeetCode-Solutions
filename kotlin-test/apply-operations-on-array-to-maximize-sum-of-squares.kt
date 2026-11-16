package applyoperationsonarraytomaximizesumofsquares

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyOperationsOnArrayToMaximizeSumOfSquaresTest {
    private val solution = Solution()

    @Test
    fun twoOperationsExample() {
        assertEquals(261, solution.maxSum(intArrayOf(2, 6, 5, 8), 2))
    }

    @Test
    fun repeatedBitCountsFormSecondValue() {
        assertEquals(98, solution.maxSum(intArrayOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun zeroOnlyArray() {
        assertEquals(0, solution.maxSum(intArrayOf(0, 0), 3))
    }

    @Test
    fun singleOperationTakesBitwiseOr() {
        assertEquals(225, solution.maxSum(intArrayOf(2, 6, 5, 8), 1))
    }
}
