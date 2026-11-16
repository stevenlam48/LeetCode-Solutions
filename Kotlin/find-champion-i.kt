package findchampioni

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun findChampion(grid: Array<IntArray>): Int {
        for (u in grid.indices) {
            if (grid[u].sum() == grid[u].size - 1) {
                return u
            }
        }
        return -1
    }
}
