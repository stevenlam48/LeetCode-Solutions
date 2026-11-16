package kthsmallestinlexicographicalorder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestInLexicographicalOrderTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(10, solution.findKthNumber(13, 2))
    }

    @Test
    fun singleNumber() {
        assertEquals(1, solution.findKthNumber(1, 1))
    }

    @Test
    fun ten() {
        assertEquals(2, solution.findKthNumber(10, 3))
    }

    @Test
    fun hundred() {
        assertEquals(17, solution.findKthNumber(100, 10))
    }

    @Test
    fun thousandLast() {
        assertEquals(999, solution.findKthNumber(1000, 1000))
    }

    @Test
    fun twoNumbers() {
        assertEquals(2, solution.findKthNumber(2, 2))
    }
}
