package searcha2dmatrixii

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        if (m == 0) {
            return false
        }
        val n = matrix[0].size
        if (n == 0) {
            return false
        }
        var i = 0
        var j = n - 1
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true
            } else if (matrix[i][j] > target) {
                --j
            } else {
                ++i
            }
        }
        return false
    }
}
