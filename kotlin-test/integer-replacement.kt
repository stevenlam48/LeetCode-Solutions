package integerreplacement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerReplacementTest {
    @Test
    fun solvesEvenExample() {
        assertEquals(3, Solution().integerReplacement(8))
    }

    @Test
    fun solvesOddExample() {
        assertEquals(4, Solution().integerReplacement(7))
    }

    @Test
    fun handlesBaseCases() {
        assertEquals(0, Solution().integerReplacement(1))
        assertEquals(1, Solution().integerReplacement(2))
        assertEquals(2, Solution().integerReplacement(3))
    }

    @Test
    fun avoidsOverflowAtMaximumInt() {
        assertEquals(32, Solution().integerReplacement(Int.MAX_VALUE))
    }
}
