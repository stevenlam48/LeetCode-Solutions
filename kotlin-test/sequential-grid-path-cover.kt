package sequentialgridpathcover

import kotlin.math.abs
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SequentialGridPathCoverTest {
    @Test
    fun exactPathOnTwoByTwo() {
        val path = Solution().findPath(arrayOf(intArrayOf(1, 2), intArrayOf(4, 3)), 1)
        assertEquals(listOf("0,0", "0,1", "1,1", "1,0"), path.map { "${it[0]},${it[1]}" })
    }

    @Test
    fun pathWithWildcardCells() {
        val grid = arrayOf(intArrayOf(1, 0), intArrayOf(0, 2))
        val original = arrayOf(grid[0].copyOf(), grid[1].copyOf())
        val path = Solution().findPath(grid, 1)
        assertValidPath(original, path)
    }

    @Test
    fun singleCell() {
        val path = Solution().findPath(arrayOf(intArrayOf(0)), 1)
        assertEquals(1, path.size)
        assertEquals(0, path[0][0])
        assertEquals(0, path[0][1])
    }

    @Test
    fun impossibleGrid() {
        val path = Solution().findPath(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1)
        assertEquals(0, path.size)
    }

    @Test
    fun spiralGridHasUniquePath() {
        val path = Solution().findPath(
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(8, 9, 4), intArrayOf(7, 6, 5)),
            1,
        )
        assertEquals(
            listOf("0,0", "0,1", "0,2", "1,2", "2,2", "2,1", "2,0", "1,0", "1,1"),
            path.map { "${it[0]},${it[1]}" },
        )
    }
}

private fun assertValidPath(grid: Array<IntArray>, path: Array<IntArray>) {
    val rows = grid.size
    val cols = grid[0].size
    assertEquals(rows * cols, path.size)
    val seen = HashSet<Int>()
    var expected = 1
    for (idx in path.indices) {
        val i = path[idx][0]
        val j = path[idx][1]
        assertTrue(i in 0 until rows && j in 0 until cols)
        assertTrue(seen.add(i * cols + j))
        if (idx > 0) {
            val pi = path[idx - 1][0]
            val pj = path[idx - 1][1]
            assertEquals(1, abs(i - pi) + abs(j - pj))
        }
        val v = grid[i][j]
        if (v != 0) {
            assertEquals(expected, v)
            ++expected
        }
    }
    assertEquals(rows * cols, seen.size)
}
