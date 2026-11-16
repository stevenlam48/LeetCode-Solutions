package largestlocalvaluesinamatrix

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        fun findMax(i: Int, j: Int): Int {
            var result = 0
            for (ni in i until i + 3) {
                for (nj in j until j + 3) {
                    result = maxOf(result, grid[ni][nj])
                }
            }
            return result
        }
        val result = Array(grid.size - 2) { IntArray(grid[0].size - 2) }
        for (i in 0 until grid.size - 2) {
            for (j in 0 until grid[0].size - 2) {
                result[i][j] = findMax(i, j)
            }
        }
        return result
    }
}
