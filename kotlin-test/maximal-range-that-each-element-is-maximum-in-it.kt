package maximalrangethateachelementismaximuminit

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximalRangeThatEachElementIsMaximumInItTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(1, 4, 2, 1, 5),
            solution.maximumLengthOfRanges(intArrayOf(1, 5, 4, 3, 6))
        )
    }

    @Test
    fun testIncreasing() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5),
            solution.maximumLengthOfRanges(intArrayOf(1, 2, 3, 4, 5))
        )
    }

    @Test
    fun testDecreasing() {
        assertArrayEquals(
            intArrayOf(5, 4, 3, 2, 1),
            solution.maximumLengthOfRanges(intArrayOf(5, 4, 3, 2, 1))
        )
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(1), solution.maximumLengthOfRanges(intArrayOf(7)))
    }
}
