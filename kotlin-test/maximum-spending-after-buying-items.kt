package maximumspendingafterbuyingitems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSpendingAfterBuyingItemsTest {
    @Test
    fun example1() {
        val values = arrayOf(
            intArrayOf(8, 5, 2),
            intArrayOf(6, 4, 1),
            intArrayOf(9, 7, 3)
        )
        assertEquals(285L, Solution().maxSpending(values))
    }

    @Test
    fun example2() {
        val values = arrayOf(
            intArrayOf(10, 8, 6, 4, 2),
            intArrayOf(9, 7, 5, 3, 1)
        )
        assertEquals(385L, Solution().maxSpending(values))
    }

    @Test
    fun singleItem() {
        assertEquals(1L, Solution().maxSpending(arrayOf(intArrayOf(1))))
    }

    @Test
    fun twoRows() {
        val values = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 1)
        )
        assertEquals(21L, Solution().maxSpending(values))
    }

    @Test
    fun singleRow() {
        assertEquals(30L, Solution().maxSpending(arrayOf(intArrayOf(4, 3, 2, 1))))
    }
}
