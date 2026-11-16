package numberofrectanglesthatcanformthelargestsquare

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfRectanglesThatCanFormTheLargestSquareTest {
    @Test
    fun testExample1() {
        val rectangles = arrayOf(
            intArrayOf(5, 8),
            intArrayOf(3, 9),
            intArrayOf(5, 12),
            intArrayOf(16, 5)
        )
        assertEquals(3, Solution().countGoodRectangles(rectangles))
    }

    @Test
    fun testExample2() {
        val rectangles = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(3, 7),
            intArrayOf(4, 3),
            intArrayOf(3, 7)
        )
        assertEquals(3, Solution().countGoodRectangles(rectangles))
    }

    @Test
    fun testSingleRectangle() {
        assertEquals(1, Solution().countGoodRectangles(arrayOf(intArrayOf(1, 1))))
    }
}
