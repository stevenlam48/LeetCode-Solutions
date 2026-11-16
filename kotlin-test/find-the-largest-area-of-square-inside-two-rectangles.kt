package findthelargestareaofsquareinsidetworectangles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLargestAreaOfSquareInsideTwoRectanglesTest {
    @Test
    fun example1() {
        val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 1))
        val topRight = arrayOf(intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(6, 6))
        assertEquals(1L, Solution().largestSquareArea(bottomLeft, topRight))
    }

    @Test
    fun example2() {
        val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(1, 2))
        val topRight = arrayOf(intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(3, 4))
        assertEquals(1L, Solution().largestSquareArea(bottomLeft, topRight))
    }

    @Test
    fun noOverlap() {
        val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(3, 3))
        val topRight = arrayOf(intArrayOf(2, 2), intArrayOf(4, 4))
        assertEquals(0L, Solution().largestSquareArea(bottomLeft, topRight))
    }

    @Test
    fun singleRectangle() {
        assertEquals(0L, Solution().largestSquareArea(arrayOf(intArrayOf(1, 1)), arrayOf(intArrayOf(2, 2))))
    }

    @Test
    fun largeOverlap() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        val topRight = arrayOf(intArrayOf(1000000000, 1000000000), intArrayOf(1000000000, 1000000000))
        assertEquals(1000000000000000000L, Solution().largestSquareArea(bottomLeft, topRight))
    }
}
