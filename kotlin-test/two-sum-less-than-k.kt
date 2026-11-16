package twosumlessthank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoSumLessThanKTest {
    @Test
    fun example1() {
        assertEquals(58, Solution().twoSumLessThanK(intArrayOf(34, 23, 1, 24, 75, 33, 54, 8), 60))
    }

    @Test
    fun noPair() {
        assertEquals(-1, Solution().twoSumLessThanK(intArrayOf(10, 20, 30), 15))
    }

    @Test
    fun twoElements() {
        assertEquals(3, Solution().twoSumLessThanK(intArrayOf(1, 2), 4))
    }

    @Test
    fun negatives() {
        assertEquals(7, Solution().twoSumLessThanK(intArrayOf(-5, 1, 6), 11))
    }
}
