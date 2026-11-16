package armstrongnumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArmstrongNumberTest {
    private val solution = Solution()

    @Test
    fun testExampleTrue() {
        assertTrue(solution.isArmstrong(153))
    }

    @Test
    fun testExampleFalse() {
        assertFalse(solution.isArmstrong(123))
    }

    @Test
    fun testSingleDigit() {
        assertTrue(solution.isArmstrong(1))
        assertTrue(solution.isArmstrong(9))
    }

    @Test
    fun testFourDigits() {
        assertTrue(solution.isArmstrong(9474))
    }

    @Test
    fun testNonArmstrongFourDigits() {
        assertFalse(solution.isArmstrong(9475))
    }
}
