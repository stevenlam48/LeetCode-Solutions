package beautifultowersi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BeautifulTowersITest {
    private val solution = Solution()

    @Test
    fun bestPeakIsFirstTower() {
        assertEquals(13L, solution.maximumSumOfHeights(intArrayOf(5, 3, 4, 1, 1)))
    }

    @Test
    fun tallInteriorPeakIsLimitedByEarlierTowers() {
        assertEquals(22L, solution.maximumSumOfHeights(intArrayOf(6, 5, 3, 9, 2, 7)))
    }

    @Test
    fun equalAdjacentPeaks() {
        assertEquals(18L, solution.maximumSumOfHeights(intArrayOf(3, 2, 5, 5, 2, 3)))
    }

    @Test
    fun singleTower() {
        assertEquals(7L, solution.maximumSumOfHeights(intArrayOf(7)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0L, solution.maximumSumOfHeights(intArrayOf()))
    }
}
