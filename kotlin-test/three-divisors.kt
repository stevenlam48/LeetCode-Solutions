package threedivisors

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ThreeDivisorsTest {
    private val solution = Solution()

    @Test
    fun twoDivisorsOnly() {
        assertFalse(solution.isThree(2))
    }

    @Test
    fun squareOfPrimeHasThreeDivisors() {
        assertTrue(solution.isThree(4))
    }

    @Test
    fun moreThanThreeDivisors() {
        assertFalse(solution.isThree(12))
    }

    @Test
    fun largerSquareOfPrime() {
        assertTrue(solution.isThree(49))
    }

    @Test
    fun oneHasSingleDivisor() {
        assertFalse(solution.isThree(1))
    }
}
