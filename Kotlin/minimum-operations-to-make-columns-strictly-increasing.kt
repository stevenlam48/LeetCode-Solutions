package minimumoperationstomakecolumnsstrictlyincreasing

// Time:  O(m * n)
// Space: O(1)

// greedy
class Solution {
    fun minimumOperations(grid: Array<IntArray>): Int {
        var result = 0
        for (i in 0 until grid.size - 1) {
            for (j in grid[0].indices) {
                if (grid[i][j] + 1 <= grid[i + 1][j]) {
                    continue
                }
                result += (grid[i][j] + 1) - grid[i + 1][j]
                grid[i + 1][j] = grid[i][j] + 1
            }
        }
        return result
    }
}
