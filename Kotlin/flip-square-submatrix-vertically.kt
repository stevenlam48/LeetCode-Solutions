package flipsquaresubmatrixvertically

// Time:  O(k^2)
// Space: O(1)

class Solution {
    fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        for (i in 0 until k / 2) {
            for (j in 0 until k) {
                val temp = grid[x + i][y + j]
                grid[x + i][y + j] = grid[x + (k - 1 - i)][y + j]
                grid[x + (k - 1 - i)][y + j] = temp
            }
        }
        return grid
    }
}
