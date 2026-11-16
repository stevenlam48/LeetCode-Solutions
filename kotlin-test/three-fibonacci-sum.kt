package threefibonaccisum

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ThreeFibonacciSumTest {
    private val solution = Solution()

    @Test
    fun twoHasRepresentableHalf() {
        assertTrue(solution.threeFibonacciSum(2))
    }

    @Test
    fun fourHasRepresentableHalf() {
        assertTrue(solution.threeFibonacciSum(4))
    }

    @Test
    fun evenNumberBetweenFibonacciValues() {
        assertFalse(solution.threeFibonacciSum(8))
    }

    @Test
    fun oddNumberIsRejected() {
        assertFalse(solution.threeFibonacciSum(3))
    }

    @Test
    fun tenHasFibonacciHalf() {
        assertTrue(solution.threeFibonacciSum(10))
    }
}
