package numberof1bits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOf1BitsTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().hammingWeight(11))
    }

    @Test
    fun powerOfTwo() {
        assertEquals(1, Solution().hammingWeight(128))
    }

    @Test
    fun allBitsSet() {
        assertEquals(32, Solution().hammingWeight(-1))
    }

    @Test
    fun zero() {
        assertEquals(0, Solution().hammingWeight(0))
    }

    @Test
    fun largePositive() {
        assertEquals(30, Solution().hammingWeight(2147483645))
    }
}
