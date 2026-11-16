package spiralmatrixiii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpiralMatrixIIITest {
    @Test
    fun singleRow() {
        val expected = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3)
        )
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrixIII(1, 4, 0, 0)))
    }

    @Test
    fun twoByTwo() {
        val expected = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrixIII(2, 2, 0, 0)))
    }

    @Test
    fun singleCell() {
        val expected = arrayOf(intArrayOf(0, 0))
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrixIII(1, 1, 0, 0)))
    }

    @Test
    fun startsInMiddle() {
        val expected = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 0),
            intArrayOf(1, 0),
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(0, 2)
        )
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrixIII(3, 3, 1, 1)))
    }
}
