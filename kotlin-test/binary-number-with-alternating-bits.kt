package binarynumberwithalternatingbits

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinaryNumberWithAlternatingBitsTest {
    @Test
    fun example1() {
        assertTrue(Solution().hasAlternatingBits(5))
    }

    @Test
    fun example2() {
        assertFalse(Solution().hasAlternatingBits(7))
    }

    @Test
    fun example3() {
        assertFalse(Solution().hasAlternatingBits(11))
    }

    @Test
    fun moreBits() {
        assertTrue(Solution().hasAlternatingBits(10))
    }

    @Test
    fun singleBit() {
        assertTrue(Solution().hasAlternatingBits(1))
    }

    @Test
    fun adjacentLowBits() {
        assertFalse(Solution().hasAlternatingBits(3))
    }
}
