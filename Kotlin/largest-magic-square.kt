package largestmagicsquare

// Time:  O(max(m, n) * min(m, n)^3)
// Space: O(m + n)

class Solution {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        val prefixRow = Array(grid.size) { IntArray(grid[0].size + 1) }
        val prefixCol = Array(grid[0].size) { IntArray(grid.size + 1) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                prefixRow[i][j + 1] = prefixRow[i][j] + grid[i][j]
                prefixCol[j][i + 1] = prefixCol[j][i] + grid[i][j]
            }
        }
        for (l in minOf(grid.size, grid[0].size) downTo 1) {
            for (i in 0..grid.size - l) {
                for (j in 0..grid[0].size - l) {
                    if (check(grid, prefixRow, prefixCol, l, i, j)) {
                        return l
                    }
                }
            }
        }
        return 1
    }

    private fun check(
        grid: Array<IntArray>,
        prefixRow: Array<IntArray>,
        prefixCol: Array<IntArray>,
        l: Int,
        i: Int,
        j: Int
    ): Boolean {
        var diag = 0
        var antiDiag = 0
        for (d in 0 until l) {
            diag += grid[i + d][j + d]
            antiDiag += grid[i + d][j + l - 1 - d]
        }
        if (diag != antiDiag) {
            return false
        }
        for (ni in i until i + l) {
            if (diag != getSum(prefixRow[ni], j, j + l - 1)) {
                return false
            }
        }
        for (nj in j until j + l) {
            if (diag != getSum(prefixCol[nj], i, i + l - 1)) {
                return false
            }
        }
        return true
    }

    private fun getSum(prefix: IntArray, a: Int, b: Int): Int = prefix[b + 1] - prefix[a]
}
