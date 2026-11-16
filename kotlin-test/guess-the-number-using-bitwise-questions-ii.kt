package guessthenumberusingbitwisequestionsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessTheNumberUsingBitwiseQuestionsIiTest {
    private class Oracle(private var n: Int) {
        fun commonBits(num: Int): Int {
            val same = 30 - Integer.bitCount(n xor num)
            n = n xor num
            return same
        }
    }

    private fun solve(hidden: Int): Int {
        val oracle = Oracle(hidden)
        return Solution(oracle::commonBits).findNumber()
    }

    @Test
    fun example1() {
        assertEquals(5, solve(5))
    }

    @Test
    fun zero() {
        assertEquals(0, solve(0))
    }

    @Test
    fun allBitsSet() {
        assertEquals((1 shl 30) - 1, solve((1 shl 30) - 1))
    }

    @Test
    fun highestBit() {
        assertEquals(1 shl 29, solve(1 shl 29))
    }

    @Test
    fun arbitraryNumber() {
        assertEquals(987654321, solve(987654321))
    }
}
