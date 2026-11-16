package reverseinteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseIntegerTest {
    @Test
    fun positive() {
        assertEquals(321, Solution().reverse(123))
    }

    @Test
    fun negative() {
        assertEquals(-321, Solution().reverse(-123))
    }

    @Test
    fun trailingZero() {
        assertEquals(21, Solution().reverse(120))
    }

    @Test
    fun zero() {
        assertEquals(0, Solution().reverse(0))
    }

    @Test
    fun overflowsPositive() {
        assertEquals(0, Solution().reverse(1534236469))
    }

    @Test
    fun overflowsNegative() {
        assertEquals(0, Solution().reverse(Int.MIN_VALUE))
    }

    @Test
    fun largestReversible() {
        assertEquals(2147483641, Solution().reverse(1463847412))
    }
}
