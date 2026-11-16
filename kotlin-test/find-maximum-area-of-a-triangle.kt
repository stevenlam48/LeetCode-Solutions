package findmaximumareaofatriangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumAreaOfATriangleTest {
    @Test
    fun example1() {
        val coords = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 3),
            intArrayOf(3, 1),
            intArrayOf(3, 3)
        )
        assertEquals(4L, Solution().maxArea(coords))
    }

    @Test
    fun example2() {
        val coords = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )
        assertEquals(-1L, Solution().maxArea(coords))
    }

    @Test
    fun example3() {
        val coords = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 2)
        )
        assertEquals(1L, Solution().maxArea(coords))
    }

    @Test
    fun singlePoint() {
        assertEquals(-1L, Solution().maxArea(arrayOf(intArrayOf(5, 5))))
    }

    @Test
    fun collinearHorizontal() {
        val coords = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(5, 0),
            intArrayOf(10, 0)
        )
        assertEquals(-1L, Solution().maxArea(coords))
    }

    @Test
    fun largeCoordinates() {
        val coords = arrayOf(
            intArrayOf(-1000000000, -1000000000),
            intArrayOf(-1000000000, 1000000000),
            intArrayOf(1000000000, -1000000000),
            intArrayOf(1000000000, 1000000000)
        )
        assertEquals(4000000000000000000L, Solution().maxArea(coords))
    }
}
