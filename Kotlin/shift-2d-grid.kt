package shift2dgrid

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        rotate(grid, k)
        return grid
    }

    private fun rotate(grid: Array<IntArray>, k: Int) {
        val total = grid.size * grid[0].size
        val shift = k % total
        reverse(grid, 0, total)
        reverse(grid, 0, shift)
        reverse(grid, shift, total)
    }

    private fun reverse(grid: Array<IntArray>, start: Int, end: Int) {
        var left = start
        var right = end
        val columns = grid[0].size
        while (left < right) {
            val startR = left / columns
            val startC = left % columns
            val endR = (right - 1) / columns
            val endC = (right - 1) % columns
            val temp = grid[startR][startC]
            grid[startR][startC] = grid[endR][endC]
            grid[endR][endC] = temp
            ++left
            --right
        }
    }
}
