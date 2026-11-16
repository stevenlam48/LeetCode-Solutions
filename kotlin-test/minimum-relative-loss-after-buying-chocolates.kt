package minimumrelativelossafterbuyingchocolates

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumRelativeLossAfterBuyingChocolatesTest {
    @Test
    fun mixedQueries() {
        val prices = intArrayOf(1, 9, 22, 10, 19)
        val queries = arrayOf(
            intArrayOf(18, 4),
            intArrayOf(50, 5),
            intArrayOf(15, 5)
        )
        assertArrayEquals(longArrayOf(34, 61, 39), Solution().minimumRelativeLosses(prices, queries))
    }

    @Test
    fun singleChocolate() {
        val queries = arrayOf(intArrayOf(5, 1))
        assertArrayEquals(longArrayOf(0), Solution().minimumRelativeLosses(intArrayOf(10), queries))
    }

    @Test
    fun allEqualPrices() {
        val queries = arrayOf(
            intArrayOf(5, 3),
            intArrayOf(4, 2)
        )
        assertArrayEquals(longArrayOf(15, 6), Solution().minimumRelativeLosses(intArrayOf(5, 5, 5), queries))
    }

    @Test
    fun buySingleWithLargeK() {
        val queries = arrayOf(intArrayOf(100, 1))
        assertArrayEquals(longArrayOf(3), Solution().minimumRelativeLosses(intArrayOf(7, 3, 9), queries))
    }
}
