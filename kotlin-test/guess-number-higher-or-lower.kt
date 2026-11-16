package guessnumberhigherorlower

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessNumberHigherOrLowerTest {
    private fun oracle(pick: Int): (Int) -> Int = { num ->
        when {
            pick < num -> -1
            pick > num -> 1
            else -> 0
        }
    }

    @Test
    fun example1() {
        assertEquals(6, Solution(oracle(6)).guessNumber(10))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution(oracle(1)).guessNumber(1))
    }

    @Test
    fun pickAtUpperBound() {
        assertEquals(10, Solution(oracle(10)).guessNumber(10))
    }

    @Test
    fun largeRange() {
        assertEquals(1702766719, Solution(oracle(1702766719)).guessNumber(2126753390))
    }

    @Test
    fun pickInMiddle() {
        assertEquals(500, Solution(oracle(500)).guessNumber(1000))
    }
}
