package divisiblegame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivisibleGameTest {
    @Test
    fun singleElement() {
        assertEquals(12, Solution().divisibleGame(intArrayOf(6)))
    }

    @Test
    fun mixedValues() {
        assertEquals(8, Solution().divisibleGame(intArrayOf(2, 3, 4)))
    }

    @Test
    fun repeatedValues() {
        assertEquals(16, Solution().divisibleGame(intArrayOf(4, 4)))
    }

    @Test
    fun primeThreeWins() {
        assertEquals(18, Solution().divisibleGame(intArrayOf(3, 3)))
    }

    @Test
    fun gapSubtracts() {
        assertEquals(12, Solution().divisibleGame(intArrayOf(2, 4, 3)))
    }
}
