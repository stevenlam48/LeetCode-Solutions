package spiralmatrixii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpiralMatrixIITest {
    @Test
    fun threeByThree() {
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(8, 9, 4),
            intArrayOf(7, 6, 5)
        )
        assertTrue(expected.contentDeepEquals(Solution().generateMatrix(3)))
    }

    @Test
    fun oneByOne() {
        assertTrue(arrayOf(intArrayOf(1)).contentDeepEquals(Solution().generateMatrix(1)))
    }

    @Test
    fun twoByTwo() {
        val expected = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(4, 3)
        )
        assertTrue(expected.contentDeepEquals(Solution().generateMatrix(2)))
    }

    @Test
    fun fourByFour() {
        val expected = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(12, 13, 14, 5),
            intArrayOf(11, 16, 15, 6),
            intArrayOf(10, 9, 8, 7)
        )
        assertTrue(expected.contentDeepEquals(Solution().generateMatrix(4)))
    }
}
