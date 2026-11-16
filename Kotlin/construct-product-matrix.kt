package constructproductmatrix

// Time:  O(m * n)
// Space: O(m * n)

// prefix sum
class Solution {
    fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val mod = 12345
        val m = grid.size
        val n = grid[0].size

        val right = LongArray(m * n + 1) { 1L }
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                right[i * n + j] = (right[i * n + j + 1] * grid[i][j]) % mod
            }
        }
        var left = 1L
        for (i in 0 until m) {
            for (j in 0 until n) {
                val x = grid[i][j]
                grid[i][j] = ((left * right[i * n + j + 1]) % mod).toInt()
                left = (left * x) % mod
            }
        }
        return grid
    }
}
