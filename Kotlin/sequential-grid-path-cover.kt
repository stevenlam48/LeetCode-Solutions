package sequentialgridpathcover

// Time:  O(m * n * 3^(m * n))
// Space: O(m * n)

class Solution {
    fun findPath(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
        val result = ArrayList<IntArray>()
        val rows = grid.size
        val cols = grid[0].size

        fun backtracking(i: Int, j: Int, curr: Int): Boolean {
            val v = grid[i][j]
            if (v != 0 && v != curr) {
                return false
            }
            grid[i][j] = -1
            result.add(intArrayOf(i, j))
            if (result.size == rows * cols) {
                return true
            }
            val newCurr = if (v == curr) curr + 1 else curr
            for (d in directions) {
                val ni = i + d[0]
                val nj = j + d[1]
                if (!(0 <= ni && ni < rows && 0 <= nj && nj < cols && grid[ni][nj] != -1)) {
                    continue
                }
                if (backtracking(ni, nj, newCurr)) {
                    return true
                }
            }
            result.removeAt(result.size - 1)
            grid[i][j] = v
            return false
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (backtracking(i, j, 1)) {
                    return result.toTypedArray()
                }
            }
        }
        return result.toTypedArray()
    }
}
