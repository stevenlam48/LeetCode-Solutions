package poweroffour

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PowerOfFourTest {
    @Test
    fun powersOfFour() {
        assertTrue(Solution().isPowerOfFour(1))
        assertTrue(Solution().isPowerOfFour(4))
        assertTrue(Solution().isPowerOfFour(16))
    }

    @Test
    fun powerOfTwoButNotFour() {
        assertFalse(Solution().isPowerOfFour(8))
    }

    @Test
    fun nonPower() {
        assertFalse(Solution().isPowerOfFour(5))
    }

    @Test
    fun nonPositiveValues() {
        assertFalse(Solution().isPowerOfFour(0))
        assertFalse(Solution().isPowerOfFour(-4))
    }
}
