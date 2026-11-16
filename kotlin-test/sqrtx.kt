package sqrtx

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SqrtxTest {
    private val solution = Solution()

    @Test
    fun returnsInputBelowTwo() {
        assertEquals(0, solution.mySqrt(0))
        assertEquals(1, solution.mySqrt(1))
    }

    @Test
    fun returnsOneForTwoAndThree() {
        assertEquals(1, solution.mySqrt(2))
        assertEquals(1, solution.mySqrt(3))
    }

    @Test
    fun returnsExactSquareRootForPerfectSquare() {
        assertEquals(4, solution.mySqrt(16))
    }

    @Test
    fun roundsDownForNonPerfectSquare() {
        assertEquals(2, solution.mySqrt(8))
    }

    @Test
    fun handlesMaximumIntWithoutOverflow() {
        assertEquals(46340, solution.mySqrt(Int.MAX_VALUE))
    }
}
