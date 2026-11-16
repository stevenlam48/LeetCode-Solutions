package minimumswapstosortbydigitsum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToSortByDigitSumTest {
    private val solution = Solution()

    @Test
    fun testAlreadySorted() {
        assertEquals(0, solution.minSwaps(intArrayOf(22, 14, 33, 7)))
    }

    @Test
    fun testNeedsTwoSwaps() {
        assertEquals(2, solution.minSwaps(intArrayOf(18, 43, 34, 16)))
    }

    @Test
    fun testNeedsOneSwap() {
        assertEquals(1, solution.minSwaps(intArrayOf(37, 100)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minSwaps(intArrayOf(5)))
    }

    @Test
    fun testTiesBrokenByValue() {
        assertEquals(1, solution.minSwaps(intArrayOf(12, 11)))
    }
}
