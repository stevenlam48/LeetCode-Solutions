package largestsubarraylengthk

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestSubarrayLengthKTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(5, 2, 3),
            solution.largestSubarray(intArrayOf(1, 4, 5, 2, 3), 3)
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(4, 5, 2, 3),
            solution.largestSubarray(intArrayOf(1, 4, 5, 2, 3), 4)
        )
    }

    @Test
    fun testKEqualsOne() {
        assertArrayEquals(
            intArrayOf(5),
            solution.largestSubarray(intArrayOf(1, 4, 5, 2, 3), 1)
        )
    }

    @Test
    fun testAllEqual() {
        assertArrayEquals(
            intArrayOf(3, 3),
            solution.largestSubarray(intArrayOf(3, 3, 3), 2)
        )
    }

    @Test
    fun testKEqualsLength() {
        assertArrayEquals(
            intArrayOf(1, 2, 3),
            solution.largestSubarray(intArrayOf(1, 2, 3), 3)
        )
    }
}
