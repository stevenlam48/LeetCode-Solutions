package kthsmallestamountwithsingledenominationcombination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestAmountWithSingleDenominationCombinationTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(9, solution.findKthSmallest(intArrayOf(3, 6, 9), 3))
    }

    @Test
    fun example2() {
        assertEquals(12, solution.findKthSmallest(intArrayOf(5, 2), 7))
    }

    @Test
    fun singleCoin() {
        assertEquals(1, solution.findKthSmallest(intArrayOf(1), 1))
    }

    @Test
    fun singleCoinLargeK() {
        assertEquals(100, solution.findKthSmallest(intArrayOf(1), 100))
    }

    @Test
    fun twoCoins() {
        assertEquals(8, solution.findKthSmallest(intArrayOf(2, 3), 5))
    }

    @Test
    fun redundantCoin() {
        assertEquals(6, solution.findKthSmallest(intArrayOf(2, 4), 3))
    }
}
