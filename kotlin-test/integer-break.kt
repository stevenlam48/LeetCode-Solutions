package integerbreak

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerBreakTest {
    @Test
    fun handlesMinimumInputs() {
        assertEquals(1, Solution().integerBreak(2))
        assertEquals(2, Solution().integerBreak(3))
    }

    @Test
    fun solvesLeetCodeExample() {
        assertEquals(36, Solution().integerBreak(10))
    }

    @Test
    fun handlesEachRemainderModuloThree() {
        assertEquals(4, Solution().integerBreak(4))
        assertEquals(6, Solution().integerBreak(5))
        assertEquals(9, Solution().integerBreak(6))
        assertEquals(12, Solution().integerBreak(7))
        assertEquals(18, Solution().integerBreak(8))
    }

    @Test
    fun handlesMaximumConstraint() {
        assertEquals(1549681956, Solution().integerBreak(58))
    }
}
