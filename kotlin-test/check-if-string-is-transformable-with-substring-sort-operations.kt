package checkifstringistransformablewithsubstringsortoperations

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfStringIsTransformableWithSubstringSortOperationsTest {
    private val solution = Solution()

    @Test
    fun transformableDigits() {
        assertTrue(solution.isTransformable("84532", "34852"))
    }

    @Test
    fun severalDigitsMoveLeft() {
        assertTrue(solution.isTransformable("34521", "23415"))
    }

    @Test
    fun largerDigitCannotCrossSmallerDigit() {
        assertFalse(solution.isTransformable("12345", "12435"))
    }

    @Test
    fun differentDigits() {
        assertFalse(solution.isTransformable("1", "2"))
    }

    @Test
    fun duplicatesKeepTheirRelativeOrder() {
        assertFalse(solution.isTransformable("112", "211"))
    }
}
