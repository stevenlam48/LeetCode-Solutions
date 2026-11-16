package countnumberofrectanglescontainingeachpoint

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountNumberOfRectanglesContainingEachPointTest {
    @Test
    fun exampleOne() {
        val rectangles = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(2, 5))
        val points = arrayOf(intArrayOf(2, 1), intArrayOf(1, 4))
        assertArrayEquals(intArrayOf(2, 1), Solution().countRectangles(rectangles, points))
    }

    @Test
    fun boundariesAndNoContainingRectangles() {
        val rectangles = arrayOf(
            intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3),
            intArrayOf(4, 4), intArrayOf(5, 5)
        )
        val points = arrayOf(
            intArrayOf(1, 3), intArrayOf(1, 1), intArrayOf(5, 1), intArrayOf(0, 6)
        )
        assertArrayEquals(intArrayOf(3, 5, 1, 0), Solution().countRectangles(rectangles, points))
    }

    @Test
    fun duplicateRectanglesAndNoPoints() {
        val rectangles = arrayOf(
            intArrayOf(2, 2), intArrayOf(2, 2), intArrayOf(3, 2), intArrayOf(1, 3)
        )
        assertArrayEquals(
            intArrayOf(3, 0),
            Solution().countRectangles(rectangles, arrayOf(intArrayOf(2, 2), intArrayOf(3, 3)))
        )
        assertArrayEquals(intArrayOf(), Solution().countRectangles(rectangles, emptyArray()))
    }
}
