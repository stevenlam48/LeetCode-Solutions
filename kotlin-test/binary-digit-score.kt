package binarydigitscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryDigitScoreTest {
    @Test
    fun firstCountAtLeastSecond() {
        assertEquals(2, Solution().calculateScore(3, 2))
    }

    @Test
    fun secondCountGreater() {
        assertEquals(2, Solution().calculateScore(2, 3))
    }

    @Test
    fun zeroes() {
        assertEquals(0, Solution().calculateScore(0, 0))
    }

    @Test
    fun equalCounts() {
        assertEquals(1, Solution().calculateScore(1, 8))
    }

    @Test
    fun integerDivisionTruncates() {
        assertEquals(2, Solution().calculateScore(3, 31))
    }

    @Test
    fun largerPopcounts() {
        assertEquals(6, Solution().calculateScore(7, 3))
    }
}
