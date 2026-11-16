package differencebetweenonesandzerosinrowandcolumn

// Time:  O(m * n)
// Space: O(m + n)

// array
class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val rows = IntArray(m)
        val cols = IntArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                rows[i] += grid[i][j]
                cols[j] += grid[i][j]
            }
        }
        val result = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                result[i][j] = rows[i] + cols[j] - (m - rows[i]) - (n - cols[j])
            }
        }
        return result
    }
}
