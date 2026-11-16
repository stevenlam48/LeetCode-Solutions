package deletegreatestvalueineachrow

// Time:  O(m * nlogn)
// Space: O(1)
class Solution {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        for (row in grid) row.sort()
        var result = 0
        for (j in grid[0].indices) {
            var mx = 0
            for (i in grid.indices) mx = maxOf(mx, grid[i][j])
            result += mx
        }
        return result
    }
}
