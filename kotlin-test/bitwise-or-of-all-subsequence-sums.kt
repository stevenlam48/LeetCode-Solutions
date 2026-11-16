package bitwiseorofallsubsequencesums

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitwiseOrOfAllSubsequenceSumsTest {
    @Test
    fun example1() {
        assertEquals(7L, Solution().subsequenceSumOr(intArrayOf(2, 1, 0, 3)))
    }

    @Test
    fun singleZero() {
        assertEquals(0L, Solution().subsequenceSumOr(intArrayOf(0)))
    }

    @Test
    fun twoElements() {
        assertEquals(3L, Solution().subsequenceSumOr(intArrayOf(1, 2)))
    }

    @Test
    fun repeatedOnes() {
        assertEquals(3L, Solution().subsequenceSumOr(intArrayOf(1, 1, 1)))
    }

    @Test
    fun largeValue() {
        assertEquals(1000000000L, Solution().subsequenceSumOr(intArrayOf(1000000000)))
    }
}
