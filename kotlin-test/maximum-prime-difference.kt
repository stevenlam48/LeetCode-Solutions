package maximumprimedifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumPrimeDifferenceTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maximumPrimeDifference(intArrayOf(4, 2, 9, 5, 3)))
    }

    @Test
    fun singlePrime() {
        assertEquals(0, Solution().maximumPrimeDifference(intArrayOf(4, 8, 2, 8)))
    }

    @Test
    fun noPrimes() {
        assertEquals(0, Solution().maximumPrimeDifference(intArrayOf(1, 1)))
    }

    @Test
    fun twoPrimes() {
        assertEquals(1, Solution().maximumPrimeDifference(intArrayOf(2, 3)))
    }

    @Test
    fun primesAtBothEnds() {
        assertEquals(4, Solution().maximumPrimeDifference(intArrayOf(2, 4, 6, 8, 11)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maximumPrimeDifference(intArrayOf(7)))
    }
}
