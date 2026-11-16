package slidingsubarraybeauty

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SlidingSubarrayBeautyTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(-1, -2, -2),
            solution.getSubarrayBeauty(intArrayOf(1, -1, -3, -2, 3), 3, 2)
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(-1, -2, -3, -4),
            solution.getSubarrayBeauty(intArrayOf(-1, -2, -3, -4, -5), 2, 2)
        )
    }

    @Test
    fun testExample3() {
        assertArrayEquals(
            intArrayOf(-3, 0, -3, -3, 0, 0, -3),
            solution.getSubarrayBeauty(intArrayOf(-3, 1, 2, -3, 0, 0, 0, -3), 2, 1)
        )
    }

    @Test
    fun testSingleElementWindow() {
        assertArrayEquals(
            intArrayOf(0, 0, -5),
            solution.getSubarrayBeauty(intArrayOf(2, 3, -5), 1, 1)
        )
    }

    @Test
    fun testWholeArray() {
        assertArrayEquals(
            intArrayOf(-1),
            solution.getSubarrayBeauty(intArrayOf(3, -1, -4, 7), 4, 2)
        )
    }
}
