package disconnectpathinabinarymatrixbyatmostoneflip

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DisconnectPathInABinaryMatrixByAtMostOneFlipTest {
    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 0),
            intArrayOf(1, 1, 1)
        )
        assertTrue(Solution().isPossibleToCutPath(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        assertFalse(Solution().isPossibleToCutPath(grid))
    }

    @Test
    fun testSingleCell() {
        assertFalse(Solution().isPossibleToCutPath(arrayOf(intArrayOf(1))))
    }

    @Test
    fun testSingleRow() {
        assertTrue(Solution().isPossibleToCutPath(arrayOf(intArrayOf(1, 1, 1))))
        assertFalse(Solution().isPossibleToCutPath(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun testSingleColumn() {
        assertTrue(Solution().isPossibleToCutPath(arrayOf(intArrayOf(1), intArrayOf(1), intArrayOf(1))))
    }
}
