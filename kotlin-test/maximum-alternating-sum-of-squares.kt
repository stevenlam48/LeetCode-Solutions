package maximumalternatingsumofsquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAlternatingSumOfSquaresTest {
    private val solution = Solution()

    @Test
    fun exampleArray() {
        assertEquals(12L, solution.maxAlternatingSum(intArrayOf(1, 2, 3)))
    }

    @Test
    fun evenNumberOfElements() {
        assertEquals(17L, solution.maxAlternatingSum(intArrayOf(2, 2, 3, 4)))
    }

    @Test
    fun signsDoNotAffectSquares() {
        assertEquals(12L, solution.maxAlternatingSum(intArrayOf(-3, 1, -2)))
    }

    @Test
    fun duplicateSquares() {
        assertEquals(1L, solution.maxAlternatingSum(intArrayOf(1, -1, 1)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0L, solution.maxAlternatingSum(intArrayOf()))
    }
}
