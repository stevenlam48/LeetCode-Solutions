package consecutivenumberssum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConsecutiveNumbersSumTest {
    @Test
    fun matchesLeetCodeExamples() {
        assertEquals(2, Solution().consecutiveNumbersSum(5))
        assertEquals(3, Solution().consecutiveNumbersSum(9))
        assertEquals(4, Solution().consecutiveNumbersSum(15))
    }

    @Test
    fun powersOfTwoHaveOnlySingleTermRepresentation() {
        assertEquals(1, Solution().consecutiveNumbersSum(1))
        assertEquals(1, Solution().consecutiveNumbersSum(2))
        assertEquals(1, Solution().consecutiveNumbersSum(64))
    }

    @Test
    fun countsAllOddDivisors() {
        assertEquals(4, Solution().consecutiveNumbersSum(21))
        assertEquals(6, Solution().consecutiveNumbersSum(45))
    }
}
