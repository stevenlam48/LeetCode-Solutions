package binarygap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryGapTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().binaryGap(22))
    }

    @Test
    fun singleBit() {
        assertEquals(0, Solution().binaryGap(8))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().binaryGap(5))
    }

    @Test
    fun adjacentBits() {
        assertEquals(1, Solution().binaryGap(6))
    }

    @Test
    fun one() {
        assertEquals(0, Solution().binaryGap(1))
    }

    @Test
    fun twoAdjacentBits() {
        assertEquals(1, Solution().binaryGap(3))
    }
}
