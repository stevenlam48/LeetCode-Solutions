package maximumscoreofsplicedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreOfSplicedArrayTest {
    private val solution = Solution()

    @Test
    fun exampleOneKeepsTheOriginallyLargerArray() {
        assertEquals(
            150,
            solution.maximumsSplicedArray(intArrayOf(60, 50, 40), intArrayOf(10, 20, 30))
        )
    }

    @Test
    fun exampleTwoSplicesOneElement() {
        assertEquals(
            130,
            solution.maximumsSplicedArray(
                intArrayOf(20, 40, 20, 10, 30),
                intArrayOf(10, 20, 10, 20, 10)
            )
        )
    }

    @Test
    fun bestSpliceCanBeAnInteriorSubarray() {
        assertEquals(
            28,
            solution.maximumsSplicedArray(intArrayOf(1, 10, 1), intArrayOf(9, 1, 9))
        )
    }

    @Test
    fun singleElementArrays() {
        assertEquals(9, solution.maximumsSplicedArray(intArrayOf(5), intArrayOf(9)))
    }

    @Test
    fun identicalArrays() {
        assertEquals(6, solution.maximumsSplicedArray(intArrayOf(3, 3), intArrayOf(3, 3)))
    }
}
