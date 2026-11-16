package creategridwithexactlykpathsii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateGridWithExactlyKPathsIiTest {
    @Test
    fun `constructs a grid with one path`() {
        assertArrayEquals(arrayOf("....", "..#."), Solution().createGrid(1))
    }

    @Test
    fun `constructs a grid with two paths`() {
        val expected = arrayOf("..##.", "..##.", "#....", "#..#.")
        assertArrayEquals(expected, Solution().createGrid(2))
    }

    @Test
    fun `zero paths produces an empty grid`() {
        assertArrayEquals(emptyArray<String>(), Solution().createGrid(0))
    }

    @Test
    fun `path counts match mixed bit patterns`() {
        for (k in intArrayOf(3, 5, 6, 8, 11, 16)) {
            assertEquals(k, pathCount(Solution().createGrid(k)), "k=$k")
        }
    }
}

private fun pathCount(grid: Array<String>): Int {
    if (grid.isEmpty()) {
        return 0
    }
    val dp = IntArray(grid[0].length)
    for (r in grid.indices) {
        var left = 0
        for (c in grid[0].indices) {
            val up = dp[c]
            dp[c] = when {
                grid[r][c] == '#' -> 0
                r == 0 && c == 0 -> 1
                else -> up + left
            }
            left = dp[c]
        }
    }
    return dp.last()
}
