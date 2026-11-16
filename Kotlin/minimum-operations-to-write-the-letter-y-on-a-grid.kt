package minimumoperationstowritetheletteryonagrid

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun minimumOperationsToWriteY(grid: Array<IntArray>): Int {
        val cnt = Array(2) { IntArray(3) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val isY = (i <= (grid[0].size - 1) / 2 && (i - j == 0 || i + j == grid[0].size - 1)) ||
                    (i > (grid[0].size - 1) / 2 && j == (grid[0].size - 1) / 2)
                ++cnt[if (isY) 1 else 0][grid[i][j]]
            }
        }
        var mx = 0
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (j == i) {
                    continue
                }
                mx = maxOf(mx, cnt[0][i] + cnt[1][j])
            }
        }
        return grid.size * grid[0].size - mx
    }
}
