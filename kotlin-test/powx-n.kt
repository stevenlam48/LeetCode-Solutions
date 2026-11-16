package powxn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PowxNTest {
    @Test
    fun positiveExponent() {
        assertEquals(1024.0, Solution().myPow(2.0, 10), 1e-9)
    }

    @Test
    fun fractionalBase() {
        assertEquals(9.261, Solution().myPow(2.1, 3), 1e-9)
    }

    @Test
    fun negativeExponent() {
        assertEquals(0.25, Solution().myPow(2.0, -2), 1e-9)
    }

    @Test
    fun zeroExponent() {
        assertEquals(1.0, Solution().myPow(5.0, 0), 1e-9)
    }

    @Test
    fun extremeExponents() {
        assertEquals(1.0, Solution().myPow(1.0, Int.MAX_VALUE), 1e-9)
        assertEquals(0.0, Solution().myPow(2.0, Int.MIN_VALUE), 1e-9)
    }
}
