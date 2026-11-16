package maximummediansumofsubsequencesofsize3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumMedianSumOfSubsequencesOfSize3Test {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(5L, solution.maximumMedianSum(intArrayOf(2, 1, 3, 2, 1, 3)))
    }

    @Test
    fun allEqual() {
        assertEquals(2L, solution.maximumMedianSum(intArrayOf(1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun singleSubsequence() {
        assertEquals(2L, solution.maximumMedianSum(intArrayOf(1, 2, 3)))
    }

    @Test
    fun nineEqualElements() {
        assertEquals(15L, solution.maximumMedianSum(intArrayOf(5, 5, 5, 5, 5, 5, 5, 5, 5)))
    }

    @Test
    fun negativeNumbers() {
        assertEquals(-6L, solution.maximumMedianSum(intArrayOf(-1, -2, -3, -4, -5, -6)))
    }
}
