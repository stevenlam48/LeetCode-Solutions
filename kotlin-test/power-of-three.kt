package powerofthree

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PowerOfThreeTest {
    @Test
    fun powersOfThree() {
        assertTrue(Solution().isPowerOfThree(1))
        assertTrue(Solution().isPowerOfThree(27))
        assertTrue(Solution().isPowerOfThree(1162261467))
    }

    @Test
    fun compositeMultiple() {
        assertFalse(Solution().isPowerOfThree(45))
    }

    @Test
    fun zero() {
        assertFalse(Solution().isPowerOfThree(0))
    }

    @Test
    fun negativeValue() {
        assertFalse(Solution().isPowerOfThree(-27))
    }
}
