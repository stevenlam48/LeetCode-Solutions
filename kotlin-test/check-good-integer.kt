package checkgoodinteger

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckGoodIntegerTest {
    private val solution = Solution()

    @Test
    fun exampleAboveThreshold() {
        assertTrue(solution.checkGoodInteger(1381))
    }

    @Test
    fun belowThreshold() {
        assertFalse(solution.checkGoodInteger(12345))
    }

    @Test
    fun thresholdCanBeReachedByOneDigit() {
        assertFalse(solution.checkGoodInteger(7))
        assertTrue(solution.checkGoodInteger(8))
    }

    @Test
    fun zeroIsNotGood() {
        assertFalse(solution.checkGoodInteger(0))
    }
}
