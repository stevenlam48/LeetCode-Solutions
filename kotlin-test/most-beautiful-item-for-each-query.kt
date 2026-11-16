package mostbeautifulitemforeachquery

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MostBeautifulItemForEachQueryTest {
    private val solution = Solution()

    @Test
    fun answersQueriesWithBestAffordableBeauty() {
        val items = arrayOf(
            intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(2, 4),
            intArrayOf(5, 6), intArrayOf(3, 5)
        )
        assertArrayEquals(
            intArrayOf(2, 4, 5, 5, 6, 6),
            solution.maximumBeauty(items, intArrayOf(1, 2, 3, 4, 5, 6))
        )
    }

    @Test
    fun returnsZeroWhenNoItemIsAffordable() {
        val items = arrayOf(intArrayOf(10, 100))
        assertArrayEquals(intArrayOf(0, 100), solution.maximumBeauty(items, intArrayOf(9, 10)))
    }

    @Test
    fun tracksMaximumBeautyAcrossEqualPrices() {
        val items = arrayOf(intArrayOf(2, 7), intArrayOf(1, 8), intArrayOf(2, 6))
        assertArrayEquals(intArrayOf(8, 8), solution.maximumBeauty(items, intArrayOf(1, 2)))
    }
}
