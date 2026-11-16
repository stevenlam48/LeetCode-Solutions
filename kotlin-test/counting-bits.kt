package countingbits

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountingBitsTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(0, 1, 1), Solution().countBits(2))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), Solution().countBits(5))
    }

    @Test
    fun zero() {
        assertArrayEquals(intArrayOf(0), Solution().countBits(0))
    }

    @Test
    fun one() {
        assertArrayEquals(intArrayOf(0, 1), Solution().countBits(1))
    }

    @Test
    fun eight() {
        assertArrayEquals(
            intArrayOf(0, 1, 1, 2, 1, 2, 2, 3, 1),
            Solution().countBits(8)
        )
    }
}
