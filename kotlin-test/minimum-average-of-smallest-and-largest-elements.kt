package minimumaverageofsmallestandlargestelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAverageOfSmallestAndLargestElementsTest {
    @Test
    fun standardExample() = assertEquals(5.5, Solution().minimumAverage(intArrayOf(7, 8, 3, 4, 15, 13, 4, 1)))

    @Test
    fun smallestInnerPair() = assertEquals(3.5, Solution().minimumAverage(intArrayOf(1, 9, 8, 3, 4, 2)))

    @Test
    fun twoElements() = assertEquals(2.0, Solution().minimumAverage(intArrayOf(2, 2)))

    @Test
    fun negativeValues() = assertEquals(-2.0, Solution().minimumAverage(intArrayOf(-5, -1, 0, 1)))
}
