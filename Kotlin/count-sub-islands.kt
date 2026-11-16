package countsubislands

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        var result = 0
        for (i in grid2.indices) {
            for (j in grid2[0].indices) {
                if (grid2[i][j] != 0) {
                    result += dfs(grid1, grid2, i, j)
                }
            }
        }
        return result
    }

    private fun dfs(grid1: Array<IntArray>, grid2: Array<IntArray>, i: Int, j: Int): Int {
        if (!(0 <= i && i < grid2.size &&
                    0 <= j && j < grid2[0].size &&
                    grid2[i][j] == 1)) {
            return 1
        }
        grid2[i][j] = 0
        var result = grid1[i][j]
        for ((di, dj) in DIRECTIONS) {
            result = result and dfs(grid1, grid2, i + di, j + dj)
        }
        return result
    }

    companion object {
        private val DIRECTIONS = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 0),
            intArrayOf(0, -1), intArrayOf(-1, 0)
        )
    }
}
