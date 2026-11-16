package cyclicallyshiftrowsandcolumns

// Time:  O(n^2)
// Space: O(1)

// array, inplace
class Solution {
    fun cyclicShift(n: Int, grid: Array<IntArray>, rowShift: IntArray, colShift: IntArray): Array<IntArray> {
        fun rotate(i0: Int, j0: Int) {
            var i = i0
            var j = j0
            var x = grid[i][j]
            while (x > 0) {
                val nj = (j - rowShift[i] + grid[0].size) % grid[0].size
                val ni = (i - colShift[nj] + grid.size) % grid.size
                val nx = grid[ni][nj]
                grid[ni][nj] = -x
                i = ni
                j = nj
                x = nx
            }
        }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                rotate(i, j)
            }
        }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                grid[i][j] = -grid[i][j]
            }
        }
        return grid
    }
}
