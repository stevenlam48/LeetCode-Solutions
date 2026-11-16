package faircandyswap

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FairCandySwapTest {
    private val solution = Solution()

    @Test
    fun equalSizedAnswerFromFirstExample() {
        assertArrayEquals(
            intArrayOf(1, 2),
            solution.fairCandySwap(intArrayOf(1, 1), intArrayOf(2, 2))
        )
    }

    @Test
    fun differentSizedAnswerFromSecondExample() {
        assertArrayEquals(
            intArrayOf(1, 2),
            solution.fairCandySwap(intArrayOf(1, 2), intArrayOf(2, 3))
        )
    }

    @Test
    fun alreadyEqualTotalsAllowExchangingEqualValues() {
        assertArrayEquals(
            intArrayOf(2, 2),
            solution.fairCandySwap(intArrayOf(2), intArrayOf(2))
        )
        assertArrayEquals(
            intArrayOf(2, 2),
            solution.fairCandySwap(intArrayOf(-1, 2, 2), intArrayOf(1, 2))
        )
    }

    @Test
    fun negativeValuesAndUnequalTotals() {
        assertArrayEquals(
            intArrayOf(3, 1),
            solution.fairCandySwap(intArrayOf(-1, 3, 6), intArrayOf(1, 3))
        )
    }

    @Test
    fun returnsEmptyWhenNoValueMatches() {
        assertArrayEquals(
            intArrayOf(),
            solution.fairCandySwap(intArrayOf(1), intArrayOf(4))
        )
    }
}
