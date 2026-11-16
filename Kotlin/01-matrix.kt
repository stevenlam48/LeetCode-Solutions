package p01matrix

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    continue
                }
                matrix[i][j] = Int.MAX_VALUE
                if (i > 0 && matrix[i - 1][j] != Int.MAX_VALUE) {
                    matrix[i][j] = minOf(matrix[i][j], matrix[i - 1][j] + 1)
                }
                if (j > 0 && matrix[i][j - 1] != Int.MAX_VALUE) {
                    matrix[i][j] = minOf(matrix[i][j], matrix[i][j - 1] + 1)
                }
            }
        }

        for (i in matrix.indices.reversed()) {
            for (j in matrix[i].indices.reversed()) {
                if (matrix[i][j] == 0) {
                    continue
                }
                if (i < matrix.size - 1 && matrix[i + 1][j] != Int.MAX_VALUE) {
                    matrix[i][j] = minOf(matrix[i][j], matrix[i + 1][j] + 1)
                }
                if (j < matrix[i].size - 1 && matrix[i][j + 1] != Int.MAX_VALUE) {
                    matrix[i][j] = minOf(matrix[i][j], matrix[i][j + 1] + 1)
                }
            }
        }

        return matrix
    }
}
