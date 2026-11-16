package numberofincreasingpathsinagrid

// Time:  O(m * n)
// Space: O(m * n)

// topological sort, bottom-up dp
class Solution {
    fun countPaths(grid: Array<IntArray>): Int {
        val MOD = 1_000_000_007
        val directions = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0)
        )

        val m = grid.size
        val n = grid[0].size
        val inDegree = Array(m) { IntArray(n) }
        var q = ArrayList<IntArray>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                for (d in directions) {
                    val ni = i + d[0]
                    val nj = j + d[1]
                    if (ni in 0 until m && nj in 0 until n && grid[i][j] > grid[ni][nj]) {
                        ++inDegree[i][j]
                    }
                }
                if (inDegree[i][j] == 0) {
                    q.add(intArrayOf(i, j))
                }
            }
        }
        val dp = Array(m) { IntArray(n) { 1 } }
        var result = 0
        while (q.isNotEmpty()) {
            val newQ = ArrayList<IntArray>()
            for (cell in q) {
                val i = cell[0]
                val j = cell[1]
                result = (result + dp[i][j]) % MOD
                for (d in directions) {
                    val ni = i + d[0]
                    val nj = j + d[1]
                    if (!(ni in 0 until m && nj in 0 until n && grid[i][j] < grid[ni][nj])) {
                        continue
                    }
                    dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % MOD
                    --inDegree[ni][nj]
                    if (inDegree[ni][nj] == 0) {
                        newQ.add(intArrayOf(ni, nj))
                    }
                }
            }
            q = newQ
        }
        return result
    }
}
