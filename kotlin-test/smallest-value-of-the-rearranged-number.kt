package smallestvalueoftherearrangednumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestValueOfTheRearrangedNumberTest {
    @Test
    fun positiveWithZero() {
        assertEquals(103L, Solution().smallestNumber(310))
    }

    @Test
    fun negative() {
        assertEquals(-7650L, Solution().smallestNumber(-7605))
    }

    @Test
    fun zero() {
        assertEquals(0L, Solution().smallestNumber(0))
    }

    @Test
    fun trailingZeros() {
        assertEquals(1000000L, Solution().smallestNumber(1000000))
    }

    @Test
    fun singleDigit() {
        assertEquals(1L, Solution().smallestNumber(1))
    }

    @Test
    fun twoDigits() {
        assertEquals(12L, Solution().smallestNumber(21))
    }
}
