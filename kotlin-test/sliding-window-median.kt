package slidingwindowmedian

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SlidingWindowMedianTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            doubleArrayOf(1.0, -1.0, -1.0, 3.0, 5.0, 6.0),
            solution.medianSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            doubleArrayOf(2.0, 3.0, 3.0, 3.0, 2.0, 3.0, 2.0),
            solution.medianSlidingWindow(intArrayOf(1, 2, 3, 4, 2, 3, 1, 4, 2), 3)
        )
    }

    @Test
    fun testEvenWindow() {
        assertArrayEquals(
            doubleArrayOf(2.5),
            solution.medianSlidingWindow(intArrayOf(1, 4, 2, 3), 4)
        )
    }

    @Test
    fun testTwoElements() {
        assertArrayEquals(
            doubleArrayOf(1.5),
            solution.medianSlidingWindow(intArrayOf(1, 2), 2)
        )
    }

    @Test
    fun testDuplicates() {
        assertArrayEquals(
            doubleArrayOf(2.0, 2.0, 2.0),
            solution.medianSlidingWindow(intArrayOf(2, 2, 2, 2, 2), 3)
        )
    }
}
