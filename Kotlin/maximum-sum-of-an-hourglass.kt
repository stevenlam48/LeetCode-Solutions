package maximumsumofanhourglass
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun maxSum(grid: Array<IntArray>): Int {
        fun total(i: Int, j: Int): Int {
            return grid[i][j] + grid[i][j + 1] + grid[i][j + 2] +
                grid[i + 1][j + 1] +
                grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]
        }

        var result = 0
        for (i in 0 until grid.size - 2) {
            for (j in 0 until grid[0].size - 2) {
                result = maxOf(result, total(i, j))
            }
        }
        return result
    }
}
