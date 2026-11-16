package countsubmatriceswithequalfrequencyofxandy
// Time:  O(n * m)
// Space: O(n * m)

class Solution {
    fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        var result = 0
        val dp1 = Array(grid.size + 1) { IntArray(grid[0].size + 1) }
        val dp2 = Array(grid.size + 1) { IntArray(grid[0].size + 1) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                dp1[i + 1][j + 1] = dp1[i][j + 1] + dp1[i + 1][j] - dp1[i][j] + if (grid[i][j] == 'X') 1 else 0
                dp2[i + 1][j + 1] = dp2[i][j + 1] + dp2[i + 1][j] - dp2[i][j] + if (grid[i][j] == 'Y') 1 else 0
                if (dp1[i + 1][j + 1] == dp2[i + 1][j + 1] && dp2[i + 1][j + 1] != 0) {
                    ++result
                }
            }
        }
        return result
    }
}
