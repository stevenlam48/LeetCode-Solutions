package checkifthereisapathwithequalnumberof0sand1s

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun isThereAPath(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        if ((m + n - 1) % 2 != 0) {
            return false
        }
        val dpLeft = Array(2) { IntArray(n + 1) { Int.MAX_VALUE } }
        dpLeft[0][1] = 0
        dpLeft[1][0] = 0
        val dpRight = Array(2) { IntArray(n + 1) { Int.MIN_VALUE } }
        dpRight[0][1] = 0
        dpRight[1][0] = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                dpLeft[(i + 1) % 2][j + 1] = minOf(dpLeft[i % 2][j + 1], dpLeft[(i + 1) % 2][j]) + grid[i][j]
                dpRight[(i + 1) % 2][j + 1] = maxOf(dpRight[i % 2][j + 1], dpRight[(i + 1) % 2][j]) + grid[i][j]
            }
        }
        val half = (m + n - 1) / 2
        return dpLeft[m % 2][n] <= half && half <= dpRight[m % 2][n]
    }
}
