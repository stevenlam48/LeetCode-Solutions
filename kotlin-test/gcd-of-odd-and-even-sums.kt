package gcdofoddandevensums

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GcdOfOddAndEvenSumsTest {
    private fun gcd(a0: Int, b0: Int): Int {
        var a = a0
        var b = b0
        while (b != 0) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }

    @Test
    fun smallValues() {
        assertEquals(1, Solution().gcdOfOddEvenSums(1))
        assertEquals(2, Solution().gcdOfOddEvenSums(2))
        assertEquals(4, Solution().gcdOfOddEvenSums(4))
        assertEquals(5, Solution().gcdOfOddEvenSums(5))
    }

    @Test
    fun matchesDefinitionForRange() {
        for (n in 1..1000) {
            val oddSum = n * n
            val evenSum = n * (n + 1)
            assertEquals(gcd(oddSum, evenSum), Solution().gcdOfOddEvenSums(n))
        }
    }

    @Test
    fun maximumN() {
        assertEquals(1000, Solution().gcdOfOddEvenSums(1000))
    }
}
