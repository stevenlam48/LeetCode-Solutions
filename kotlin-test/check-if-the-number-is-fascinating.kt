package checkifthenumberisfascinating

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfTheNumberIsFascinatingTest {
    private val solution = Solution()

    @Test
    fun fascinating192() {
        assertTrue(solution.isFascinating(192))
    }

    @Test
    fun zeroDigitAppears() {
        assertFalse(solution.isFascinating(100))
    }

    @Test
    fun fascinating219() {
        assertTrue(solution.isFascinating(219))
    }

    @Test
    fun repeatedDigits() {
        assertFalse(solution.isFascinating(123))
    }

    @Test
    fun fascinating273() {
        assertTrue(solution.isFascinating(273))
    }
}
