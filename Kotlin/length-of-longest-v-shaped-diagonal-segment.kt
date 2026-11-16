package lengthoflongestvshapeddiagonalsegment

// Time:  O(n * m)
// Space: O(n * m)

class Solution {
    fun lenOfVDiagonal(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var result = 0
        val downRight = Array(n) { IntArray(m) { 1 } }
        val downLeft = Array(n) { IntArray(m) { 1 } }
        for (i in 0 until n) {
            for (j in 0 until m) {
                val x = grid[i][j]
                if (x == 1) {
                    result = 1
                    continue
                }
                if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 2 - x) {
                    downRight[i][j] = downRight[i - 1][j - 1] + 1
                }
                if (i - 1 >= 0 && j + 1 < m && grid[i - 1][j + 1] == 2 - x) {
                    downLeft[i][j] = downLeft[i - 1][j + 1] + 1
                }
            }
        }
        val upRight = Array(n) { IntArray(m) { 1 } }
        val upLeft = Array(n) { IntArray(m) { 1 } }
        for (i in n - 1 downTo 0) {
            for (j in 0 until m) {
                val x = grid[i][j]
                if (x == 1) {
                    continue
                }
                if (i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] == 2 - x) {
                    upRight[i][j] = upRight[i + 1][j - 1] + 1
                }
                if (i + 1 < n && j + 1 < m && grid[i + 1][j + 1] == 2 - x) {
                    upLeft[i][j] = upLeft[i + 1][j + 1] + 1
                }
            }
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                val x = grid[i][j]
                if (x == 1) {
                    continue
                }
                if ((downRight[i][j] % 2 == 0 && x == 0) || (downRight[i][j] % 2 == 1 && x == 2)) {
                    val ni = i - downRight[i][j]
                    val nj = j - downRight[i][j]
                    if (ni in 0 until n && nj in 0 until m && grid[ni][nj] == 1) {
                        result = maxOf(result, downRight[i][j] + upRight[i][j])
                    }
                }
                if ((downLeft[i][j] % 2 == 0 && x == 0) || (downLeft[i][j] % 2 == 1 && x == 2)) {
                    val ni = i - downLeft[i][j]
                    val nj = j + downLeft[i][j]
                    if (ni in 0 until n && nj in 0 until m && grid[ni][nj] == 1) {
                        result = maxOf(result, downLeft[i][j] + downRight[i][j])
                    }
                }
                if ((upLeft[i][j] % 2 == 0 && x == 0) || (upLeft[i][j] % 2 == 1 && x == 2)) {
                    val ni = i + upLeft[i][j]
                    val nj = j + upLeft[i][j]
                    if (ni in 0 until n && nj in 0 until m && grid[ni][nj] == 1) {
                        result = maxOf(result, upLeft[i][j] + downLeft[i][j])
                    }
                }
                if ((upRight[i][j] % 2 == 0 && x == 0) || (upRight[i][j] % 2 == 1 && x == 2)) {
                    val ni = i + upRight[i][j]
                    val nj = j - upRight[i][j]
                    if (ni in 0 until n && nj in 0 until m && grid[ni][nj] == 1) {
                        result = maxOf(result, upRight[i][j] + upLeft[i][j])
                    }
                }
            }
        }
        return result
    }
}
