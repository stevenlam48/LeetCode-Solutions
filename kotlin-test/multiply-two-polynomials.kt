package multiplytwopolynomials

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MultiplyTwoPolynomialsTest {
    @Test
    fun example1() {
        assertArrayEquals(
            longArrayOf(4, 13, 28, 27, 18),
            Solution().multiply(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        )
    }

    @Test
    fun sparsePolynomials() {
        assertArrayEquals(
            longArrayOf(1, 0, 0, 2, 0, 0, 1),
            Solution().multiply(intArrayOf(1, 0, 0, 1), intArrayOf(1, 0, 0, 1))
        )
    }

    @Test
    fun singleTerms() {
        assertArrayEquals(longArrayOf(35), Solution().multiply(intArrayOf(5), intArrayOf(7)))
    }

    @Test
    fun negativeCoefficients() {
        assertArrayEquals(
            longArrayOf(3, -2, -8),
            Solution().multiply(intArrayOf(1, -2), intArrayOf(3, 4))
        )
    }

    @Test
    fun constantTimesPolynomial() {
        assertArrayEquals(
            longArrayOf(2, 4, 6),
            Solution().multiply(intArrayOf(2), intArrayOf(1, 2, 3))
        )
    }
}
