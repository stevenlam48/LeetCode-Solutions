package minimumnumberofflipstomakebinarygridpalindromicii

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun minFlips(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var result = 0
        for (i in 0 until m / 2) {
            for (j in 0 until n / 2) {
                val c = grid[i][j] + grid[i][n - 1 - j] +
                    grid[m - 1 - i][j] + grid[m - 1 - i][n - 1 - j]
                result += minOf(c, 4 - c)
            }
        }
        var diff = 0
        var cnt1 = 0
        if (m % 2 != 0) {
            for (j in 0 until n / 2) {
                diff += grid[m / 2][j] xor grid[m / 2][n - 1 - j]
                cnt1 += grid[m / 2][j] + grid[m / 2][n - 1 - j]
            }
        }
        if (n % 2 != 0) {
            for (i in 0 until m / 2) {
                diff += grid[i][n / 2] xor grid[m - 1 - i][n / 2]
                cnt1 += grid[i][n / 2] + grid[m - 1 - i][n / 2]
            }
        }
        if (m % 2 != 0 && n % 2 != 0) {
            result += grid[m / 2][n / 2]
        }
        if (diff == 0) {
            result += (4 - cnt1 % 4) % 4
        }
        return result + diff
    }
}
