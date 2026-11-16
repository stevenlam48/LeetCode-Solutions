package stampingthegrid

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun possibleToStamp(grid: Array<IntArray>, stampHeight: Int, stampWidth: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        val prefix = Array(m + 1) { IntArray(n + 1) }
        val fit = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + (1 xor grid[i][j])
                if (i + 1 >= stampHeight && j + 1 >= stampWidth) {
                    val x = i + 1 - stampHeight
                    val y = j + 1 - stampWidth
                    fit[i][j] = if (prefix[i + 1][j + 1] - prefix[x][j + 1] - prefix[i + 1][y] + prefix[x][y] == stampWidth * stampHeight) 1 else 0
                }
            }
        }
        val prefix2 = Array(m + 1) { IntArray(n + 1) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                prefix2[i + 1][j + 1] = prefix2[i + 1][j] + prefix2[i][j + 1] - prefix2[i][j] + fit[i][j]
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                val x = minOf(i + stampHeight, m)
                val y = minOf(j + stampWidth, n)
                if (grid[i][j] == 0 && prefix2[x][y] - prefix2[i][y] - prefix2[x][j] + prefix2[i][j] == 0) {
                    return false
                }
            }
        }
        return true
    }
}
