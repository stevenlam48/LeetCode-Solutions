package guessthenumberusingbitwisequestionsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessTheNumberUsingBitwiseQuestionsITest {
    private fun oracle(hidden: Int): (Int) -> Int = { num -> Integer.bitCount(num and hidden) }

    @Test
    fun example1() {
        assertEquals(5, Solution(oracle(5)).findNumber())
    }

    @Test
    fun zero() {
        assertEquals(0, Solution(oracle(0)).findNumber())
    }

    @Test
    fun allBitsSet() {
        assertEquals((1 shl 30) - 1, Solution(oracle((1 shl 30) - 1)).findNumber())
    }

    @Test
    fun highestBit() {
        assertEquals(1 shl 29, Solution(oracle(1 shl 29)).findNumber())
    }

    @Test
    fun arbitraryNumber() {
        assertEquals(123456789, Solution(oracle(123456789)).findNumber())
    }
}
