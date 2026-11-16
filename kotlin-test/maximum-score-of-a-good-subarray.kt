package maximumscoreofagoodsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreOfAGoodSubarrayTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(15, solution.maximumScore(intArrayOf(1, 4, 3, 7, 4, 5), 3))
    }

    @Test
    fun exampleTwo() {
        assertEquals(20, solution.maximumScore(intArrayOf(5, 5, 4, 5, 4, 1, 1, 1), 0))
    }

    @Test
    fun singleElement() {
        assertEquals(7, solution.maximumScore(intArrayOf(7), 0))
    }

    @Test
    fun equalElementsUseWholeArray() {
        assertEquals(8, solution.maximumScore(intArrayOf(2, 2, 2, 2), 2))
    }
}
