package lengthoflongestvshapeddiagonalsegment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLongestVShapedDiagonalSegmentTest {
    @Test
    fun singleApex() {
        val grid = arrayOf(intArrayOf(1))
        assertEquals(1, Solution().lenOfVDiagonal(grid))
    }

    @Test
    fun noApex() {
        val grid = arrayOf(intArrayOf(0))
        assertEquals(0, Solution().lenOfVDiagonal(grid))
    }

    @Test
    fun straightDiagonalSegment() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 2, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(3, Solution().lenOfVDiagonal(grid))
    }

    @Test
    fun fourCellSegmentWithTurn() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 2, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 2, 0, 0)
        )
        assertEquals(4, Solution().lenOfVDiagonal(grid))
    }

    @Test
    fun allOnes() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(1, Solution().lenOfVDiagonal(grid))
    }
}
