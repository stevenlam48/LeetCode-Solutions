package sortmatrixbydiagonals

// Time:  O(n^2 * logn)
// Space: O(n^2)

class Solution {
    fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
        val shift = grid[0].size - 1
        val lookup = Array(grid.size + grid[0].size - 1) { mutableListOf<Int>() }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                lookup[i - j + shift].add(grid[i][j])
            }
        }
        for (i in lookup.indices) {
            if (i - shift < 0) {
                lookup[i].sortDescending()
            } else {
                lookup[i].sort()
            }
        }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                grid[i][j] = lookup[i - j + shift].removeAt(lookup[i - j + shift].lastIndex)
            }
        }
        return grid
    }
}
