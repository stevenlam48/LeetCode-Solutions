package findthedivisibilityarrayofastring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDivisibilityArrayOfAStringTest {
    @Test
    fun tracksPrefixRemainders() {
        assertArrayEquals(intArrayOf(1, 1, 0, 0, 0, 1, 1, 0, 0), Solution().divisibilityArray("998244353", 3))
    }

    @Test
    fun handlesTrailingZeros() {
        assertArrayEquals(intArrayOf(0, 1, 0, 1), Solution().divisibilityArray("1010", 10))
    }

    @Test
    fun handlesZeroPrefixAndModulusOne() {
        assertArrayEquals(intArrayOf(1), Solution().divisibilityArray("0", 1))
    }

    @Test
    fun handlesEmptyString() {
        assertArrayEquals(intArrayOf(), Solution().divisibilityArray("", 7))
    }
}
