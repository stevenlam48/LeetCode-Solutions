package addtwointegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddTwoIntegersTest {
    private val solution = Solution()

    @Test
    fun positiveNumbers() {
        assertEquals(17, solution.sum(12, 5))
    }

    @Test
    fun negativeResult() {
        assertEquals(-3, solution.sum(-10, 7))
    }

    @Test
    fun zero() {
        assertEquals(0, solution.sum(0, 0))
    }
}
