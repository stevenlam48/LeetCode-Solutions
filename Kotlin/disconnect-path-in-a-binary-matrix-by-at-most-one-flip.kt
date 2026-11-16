package disconnectpathinabinarymatrixbyatmostoneflip

// Time:  O(m * n)
// Space: O(m + n)

// dp
class Solution {
    fun isPossibleToCutPath(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if ((i == 0 && j == 0) || grid[i][j] == 0) {
                    continue
                }
                if ((i - 1 < 0 || grid[i - 1][j] == 0) && (j - 1 < 0 || grid[i][j - 1] == 0)) {
                    grid[i][j] = 0
                }
            }
        }
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if ((i == m - 1 && j == n - 1) || grid[i][j] == 0) {
                    continue
                }
                if ((i + 1 >= m || grid[i + 1][j] == 0) && (j + 1 >= n || grid[i][j + 1] == 0)) {
                    grid[i][j] = 0
                }
            }
        }
        val cnt = IntArray(m + n - 1)
        for (i in 0 until m) {
            for (j in 0 until n) {
                cnt[i + j] += grid[i][j]
            }
        }
        for (k in 1 until cnt.size - 1) {
            if (cnt[k] <= 1) {
                return true
            }
        }
        return false
    }
}
