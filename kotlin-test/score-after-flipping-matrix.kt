package scoreafterflippingmatrix

// Time:  O(r * c)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScoreAfterFlippingMatrixTest {
    @Test
    fun example() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0)
        )
        assertEquals(39, Solution().matrixScore(grid))
    }

    @Test
    fun singleCells() {
        assertEquals(1, Solution().matrixScore(arrayOf(intArrayOf(0))))
        assertEquals(1, Solution().matrixScore(arrayOf(intArrayOf(1))))
    }

    @Test
    fun uniformRows() {
        assertEquals(6, Solution().matrixScore(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
        assertEquals(6, Solution().matrixScore(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun singleRow() {
        assertEquals(7, Solution().matrixScore(arrayOf(intArrayOf(0, 1, 0))))
    }
}
