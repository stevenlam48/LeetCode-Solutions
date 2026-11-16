package theknightstour

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TheKnightsTourTest {

    private val moves = arrayOf(
        intArrayOf(1, 2), intArrayOf(-1, 2), intArrayOf(1, -2), intArrayOf(-1, -2),
        intArrayOf(2, 1), intArrayOf(-2, 1), intArrayOf(2, -1), intArrayOf(-2, -1)
    )

    private fun assertValidTour(grid: Array<IntArray>, m: Int, n: Int, r: Int, c: Int) {
        assertEquals(m, grid.size)
        assertEquals(n, grid[0].size)
        val pos = Array(m * n) { IntArray(2) { -1 } }
        for (i in 0 until m) {
            for (j in 0 until n) {
                val v = grid[i][j]
                assertTrue(v in 0 until m * n, "value out of range")
                assertEquals(-1, pos[v][0], "duplicate value $v")
                pos[v][0] = i
                pos[v][1] = j
            }
        }
        assertEquals(r, pos[0][0])
        assertEquals(c, pos[0][1])
        for (k in 1 until m * n) {
            val dr = Math.abs(pos[k][0] - pos[k - 1][0])
            val dc = Math.abs(pos[k][1] - pos[k - 1][1])
            assertTrue((dr == 1 && dc == 2) || (dr == 2 && dc == 1), "invalid move at step $k")
        }
    }

    @Test
    fun testSingleCell() {
        assertValidTour(Solution().tourOfKnight(1, 1, 0, 0), 1, 1, 0, 0)
    }

    @Test
    fun testFiveByFive() {
        assertValidTour(Solution().tourOfKnight(5, 5, 0, 0), 5, 5, 0, 0)
    }

    @Test
    fun testNonZeroStart() {
        assertValidTour(Solution().tourOfKnight(6, 6, 2, 3), 6, 6, 2, 3)
    }

    @Test
    fun testSixBySix() {
        assertValidTour(Solution().tourOfKnight(6, 6, 1, 1), 6, 6, 1, 1)
    }

    @Test
    fun testRectangularBoard() {
        assertValidTour(Solution().tourOfKnight(5, 4, 0, 0), 5, 4, 0, 0)
    }
}
