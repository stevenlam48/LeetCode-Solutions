package poweroftwo

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PowerOfTwoTest {
    @Test
    fun powersOfTwo() {
        assertTrue(Solution().isPowerOfTwo(1))
        assertTrue(Solution().isPowerOfTwo(2))
        assertTrue(Solution().isPowerOfTwo(1024))
    }

    @Test
    fun nonPower() {
        assertFalse(Solution().isPowerOfTwo(3))
    }

    @Test
    fun zero() {
        assertFalse(Solution().isPowerOfTwo(0))
    }

    @Test
    fun negativeValue() {
        assertFalse(Solution().isPowerOfTwo(-2))
    }
}
