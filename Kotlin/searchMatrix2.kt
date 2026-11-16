package searchMatrix2

// Time Complexity: O(log(mn))
// Space Complexity: O(1)

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }
        val m = matrix.size
        val n = matrix[0].size
        var start = 0
        var end = m * n
        while (start < end) {
            val mid = (start + end) / 2
            val value = matrix[mid / n][mid % n]
            if (target == value) {
                return true
            } else if (value < target) {
                start = mid + 1
            } else {
                end = mid
            }
        }
        return false
    }
}
