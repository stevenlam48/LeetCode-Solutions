package countnegativenumbersinasortedmatrix

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var result = 0
        var c = grid[0].size - 1
        for (row in grid) {
            while (c >= 0 && row[c] < 0) {
                --c
            }
            result += grid[0].size - 1 - c
        }
        return result
    }
}
