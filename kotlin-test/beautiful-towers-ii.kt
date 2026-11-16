package beautifultowersii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BeautifulTowersIiTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(13L, solution.maximumSumOfHeights(intArrayOf(5, 3, 4, 1, 1)))
    }

    @Test
    fun secondExample() {
        assertEquals(22L, solution.maximumSumOfHeights(intArrayOf(6, 5, 3, 9, 2, 7)))
    }

    @Test
    fun thirdExample() {
        assertEquals(18L, solution.maximumSumOfHeights(intArrayOf(3, 2, 5, 5, 2, 3)))
    }

    @Test
    fun singleTower() {
        assertEquals(7L, solution.maximumSumOfHeights(intArrayOf(7)))
    }

    @Test
    fun noTowers() {
        assertEquals(0L, solution.maximumSumOfHeights(intArrayOf()))
    }
}
