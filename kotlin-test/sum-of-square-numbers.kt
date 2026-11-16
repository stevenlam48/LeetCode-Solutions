package sumofsquarenumbers

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SumOfSquareNumbersTest {
    private val solution = Solution()

    @Test
    fun sumOfDistinctNonzeroSquares() {
        assertTrue(solution.judgeSquareSum(5))
    }

    @Test
    fun notASumOfTwoSquares() {
        assertFalse(solution.judgeSquareSum(3))
    }

    @Test
    fun zero() {
        assertTrue(solution.judgeSquareSum(0))
    }

    @Test
    fun perfectSquareWithZeroAddend() {
        assertTrue(solution.judgeSquareSum(4))
    }

    @Test
    fun equalSquares() {
        assertTrue(solution.judgeSquareSum(2))
    }
}
