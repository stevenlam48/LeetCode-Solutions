package happynumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HappyNumberTest {
    private val solution = Solution()

    @Test
    fun happyNumber() {
        assertTrue(solution.isHappy(19))
    }

    @Test
    fun unhappyNumber() {
        assertFalse(solution.isHappy(2))
    }

    @Test
    fun oneIsAlreadyHappy() {
        assertTrue(solution.isHappy(1))
    }

    @Test
    fun nextNumberSumsSquaredDigits() {
        assertEquals(1, solution.nextNumber(10))
        assertEquals(100, solution.nextNumber(68))
        assertEquals(0, solution.nextNumber(0))
    }
}
