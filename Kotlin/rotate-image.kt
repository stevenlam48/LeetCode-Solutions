package rotateimage

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in 0 until n / 2) {
            for (j in i until n - 1 - i) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = tmp
            }
        }
    }
}
