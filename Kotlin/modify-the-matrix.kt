package modifythematrix
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun modifiedMatrix(matrix: Array<IntArray>): Array<IntArray> {
        for (j in matrix[0].indices) {
            var mx = -1
            for (i in matrix.indices) {
                mx = maxOf(mx, matrix[i][j])
            }
            for (i in matrix.indices) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = mx
                }
            }
        }
        return matrix
    }
}
