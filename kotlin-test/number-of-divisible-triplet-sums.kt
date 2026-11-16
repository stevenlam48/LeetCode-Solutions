package numberofdivisibletripletsums

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfDivisibleTripletSumsTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().divisibleTripletCount(intArrayOf(3, 3, 4, 7, 8), 5))
    }

    @Test
    fun testAllEqual() {
        assertEquals(4, Solution().divisibleTripletCount(intArrayOf(3, 3, 3, 3), 3))
    }

    @Test
    fun testDivisorOne() {
        assertEquals(1, Solution().divisibleTripletCount(intArrayOf(3, 3, 3), 1))
    }

    @Test
    fun testTooFewElements() {
        assertEquals(0, Solution().divisibleTripletCount(intArrayOf(1, 2), 1))
    }

    @Test
    fun testFiveOnes() {
        assertEquals(10, Solution().divisibleTripletCount(intArrayOf(1, 1, 1, 1, 1), 3))
    }
}
