package diagonaltraverse

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return intArrayOf()
        }
        val result = IntArray(matrix.size * matrix[0].size)
        var row = 0
        var col = 0
        var d = 0
        val dirs = arrayOf(intArrayOf(-1, 1), intArrayOf(1, -1))
        for (i in result.indices) {
            result[i] = matrix[row][col]
            row += dirs[d][0]
            col += dirs[d][1]
            if (row >= matrix.size) {
                row = matrix.size - 1
                col += 2
                d = 1 - d
            } else if (col >= matrix[0].size) {
                col = matrix[0].size - 1
                row += 2
                d = 1 - d
            } else if (row < 0) {
                row = 0
                d = 1 - d
            } else if (col < 0) {
                col = 0
                d = 1 - d
            }
        }
        return result
    }
}
