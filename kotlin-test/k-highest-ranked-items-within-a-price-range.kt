package khighestrankeditemswithinapricerange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class KHighestRankedItemsWithinAPriceRangeTest {
    private fun assertCoordinates(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun `ranks by distance before price`() {
        val grid = arrayOf(intArrayOf(1, 2, 0, 1), intArrayOf(1, 3, 0, 1), intArrayOf(0, 2, 5, 1))
        assertCoordinates(
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(2, 1)),
            Solution().highestRankedKItems(grid, intArrayOf(2, 5), intArrayOf(0, 0), 3)
        )
    }

    @Test
    fun `uses price to rank items at equal distance`() {
        val grid = arrayOf(intArrayOf(1, 2, 0, 1), intArrayOf(1, 3, 3, 1), intArrayOf(0, 2, 5, 1))
        assertCoordinates(
            arrayOf(intArrayOf(2, 1), intArrayOf(1, 2)),
            Solution().highestRankedKItems(grid, intArrayOf(2, 3), intArrayOf(2, 3), 2)
        )
    }

    @Test
    fun `returns fewer items when not enough qualify`() {
        val grid = arrayOf(intArrayOf(1, 1, 1), intArrayOf(0, 0, 1), intArrayOf(2, 3, 4))
        assertCoordinates(
            arrayOf(intArrayOf(2, 1), intArrayOf(2, 0)),
            Solution().highestRankedKItems(grid, intArrayOf(2, 3), intArrayOf(0, 0), 3)
        )
    }

    @Test
    fun `zero k returns no coordinates`() {
        val result = Solution().highestRankedKItems(
            arrayOf(intArrayOf(2)), intArrayOf(2, 2), intArrayOf(0, 0), 0
        )
        assertEquals(0, result.size)
    }
}
