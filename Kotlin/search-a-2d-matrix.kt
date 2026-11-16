package searcha2dmatrix

// Time:  O(logm + logn)
// Space: O(1)

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }
        val m = matrix.size
        val n = matrix[0].size
        var left = 0
        var right = m * n - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (matrix[mid / n][mid % n] >= target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left != m * n && matrix[left / n][left % n] == target
    }
}
