package toeplitzmatrix
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (i != 0 && j != 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false
                }
            }
        }
        return true
    }
}
