package numberofevenandoddbits

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfEvenAndOddBitsTest {
    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(2, 0), Solution().evenOddBit(17))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(0, 1), Solution().evenOddBit(2))
    }

    @Test
    fun testZero() {
        assertArrayEquals(intArrayOf(0, 0), Solution().evenOddBit(0))
    }

    @Test
    fun testOne() {
        assertArrayEquals(intArrayOf(1, 0), Solution().evenOddBit(1))
    }

    @Test
    fun testThree() {
        assertArrayEquals(intArrayOf(1, 1), Solution().evenOddBit(3))
    }
}
