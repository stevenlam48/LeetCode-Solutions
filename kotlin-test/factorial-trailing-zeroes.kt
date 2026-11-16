package factorialtrailingzeroes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FactorialTrailingZeroesTest {
    private val solution = Solution()

    @Test
    fun smallValuesHaveNoTrailingZeroes() {
        assertEquals(0, solution.trailingZeroes(0))
        assertEquals(0, solution.trailingZeroes(3))
        assertEquals(0, solution.trailingZeroes(4))
    }

    @Test
    fun multiplesOfFive() {
        assertEquals(1, solution.trailingZeroes(5))
        assertEquals(2, solution.trailingZeroes(10))
        assertEquals(6, solution.trailingZeroes(25))
    }

    @Test
    fun powersOfFiveContributeRepeatedly() {
        assertEquals(31, solution.trailingZeroes(125))
        assertEquals(156, solution.trailingZeroes(625))
    }

    @Test
    fun largerValue() {
        assertEquals(249, solution.trailingZeroes(1000))
    }
}
