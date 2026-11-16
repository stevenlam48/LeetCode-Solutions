package perfectnumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PerfectNumberTest {
    private val solution = Solution()

    @Test
    fun testPerfectNumbers() {
        assertTrue(solution.checkPerfectNumber(6))
        assertTrue(solution.checkPerfectNumber(28))
        assertTrue(solution.checkPerfectNumber(496))
    }

    @Test
    fun testNonPerfectNumbers() {
        assertFalse(solution.checkPerfectNumber(1))
        assertFalse(solution.checkPerfectNumber(2))
        assertFalse(solution.checkPerfectNumber(12))
    }

    @Test
    fun testNonPositive() {
        assertFalse(solution.checkPerfectNumber(0))
        assertFalse(solution.checkPerfectNumber(-6))
    }
}
