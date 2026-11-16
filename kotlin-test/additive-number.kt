package additivenumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AdditiveNumberTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertTrue(solution.isAdditiveNumber("112358"))
    }

    @Test
    fun secondExample() {
        assertTrue(solution.isAdditiveNumber("199100199"))
    }

    @Test
    fun invalidSequence() {
        assertFalse(solution.isAdditiveNumber("1203"))
    }

    @Test
    fun singleDigitSequence() {
        assertTrue(solution.isAdditiveNumber("101"))
    }

    @Test
    fun zerosAreValidSingleDigitNumbers() {
        assertTrue(solution.isAdditiveNumber("000"))
    }

    @Test
    fun leadingZeroInvalidatesSequence() {
        assertFalse(solution.isAdditiveNumber("0235813"))
    }
}
