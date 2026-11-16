package slidingwindowmaximum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SlidingWindowMaximumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(3, 3, 5, 5, 6, 7),
            solution.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        )
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(1), solution.maxSlidingWindow(intArrayOf(1), 1))
    }

    @Test
    fun testWindowOfOne() {
        assertArrayEquals(
            intArrayOf(1, -1),
            solution.maxSlidingWindow(intArrayOf(1, -1), 1)
        )
    }

    @Test
    fun testWindowOfTwo() {
        assertArrayEquals(intArrayOf(11), solution.maxSlidingWindow(intArrayOf(9, 11), 2))
    }

    @Test
    fun testDecreasing() {
        assertArrayEquals(
            intArrayOf(4, 3, 2),
            solution.maxSlidingWindow(intArrayOf(4, 3, 2, 1), 2)
        )
    }
}
