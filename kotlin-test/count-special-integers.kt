package countspecialintegers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSpecialIntegersTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(19, solution.countSpecialNumbers(20))
    }

    @Test
    fun example2() {
        assertEquals(5, solution.countSpecialNumbers(5))
    }

    @Test
    fun example3() {
        assertEquals(110, solution.countSpecialNumbers(135))
    }

    @Test
    fun singleDigit() {
        assertEquals(9, solution.countSpecialNumbers(9))
    }

    @Test
    fun twoDigits() {
        assertEquals(10, solution.countSpecialNumbers(10))
    }

    @Test
    fun hundred() {
        assertEquals(90, solution.countSpecialNumbers(100))
    }
}
