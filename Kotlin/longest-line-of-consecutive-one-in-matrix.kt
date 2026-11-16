package longestlineofconsecutiveoneinmatrix

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun longestLine(M: Array<IntArray>): Int {
        if (M.isEmpty()) {
            return 0
        }
        val rows = M.size
        val cols = M[0].size
        var result = 0
        val dp = Array(2) { Array(cols) { IntArray(4) } }
        for (i in 0 until rows) {
            val cur = dp[i % 2]
            for (j in 0 until cols) {
                for (t in 0 until 4) {
                    cur[j][t] = 0
                }
                if (M[i][j] == 1) {
                    cur[j][0] = if (j > 0) cur[j - 1][0] + 1 else 1
                    cur[j][1] = if (i > 0) dp[(i - 1) % 2][j][1] + 1 else 1
                    cur[j][2] = if (i > 0 && j > 0) dp[(i - 1) % 2][j - 1][2] + 1 else 1
                    cur[j][3] = if (i > 0 && j < cols - 1) dp[(i - 1) % 2][j + 1][3] + 1 else 1
                    result = maxOf(result, cur[j][0], cur[j][1], cur[j][2], cur[j][3])
                }
            }
        }
        return result
    }
}
