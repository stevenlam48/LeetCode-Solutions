package matrixdiagonalsum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size
        var result = 0
        for (i in 0 until n) {
            result += mat[i][i] + mat[n - 1 - i][i]
        }
        if (n % 2 != 0) {
            result -= mat[n / 2][n / 2]
        }
        return result
    }
}
