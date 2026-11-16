package maximumsumwithatmostkelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumWithAtMostKElementsTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            20L,
            solution.maxSum(
                arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                intArrayOf(1, 2, 1),
                3
            )
        )
    }

    @Test
    fun twoRows() {
        assertEquals(
            21L,
            solution.maxSum(
                arrayOf(intArrayOf(5, 3, 7), intArrayOf(8, 2, 6)),
                intArrayOf(2, 2),
                3
            )
        )
    }

    @Test
    fun singleCell() {
        assertEquals(1L, solution.maxSum(arrayOf(intArrayOf(1)), intArrayOf(1), 1))
    }

    @Test
    fun limitCapsEachRow() {
        assertEquals(
            20L,
            solution.maxSum(
                arrayOf(intArrayOf(10, 10), intArrayOf(10, 10)),
                intArrayOf(1, 1),
                2
            )
        )
    }
}
