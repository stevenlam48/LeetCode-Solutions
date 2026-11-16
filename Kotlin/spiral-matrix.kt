package spiralmatrix

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = mutableListOf<Int>()
        if (matrix.isEmpty()) {
            return res
        }

        var left = 0
        var right = matrix[0].size - 1
        var top = 0
        var bottom = matrix.size - 1
        while (left <= right && top <= bottom) {
            for (j in left..right) {
                res.add(matrix[top][j])
            }
            for (i in top + 1 until bottom) {
                res.add(matrix[i][right])
            }
            if (top < bottom) {
                for (j in right downTo left) {
                    res.add(matrix[bottom][j])
                }
            }
            if (left < right) {
                for (i in bottom - 1 downTo top + 1) {
                    res.add(matrix[i][left])
                }
            }
            ++left
            --right
            ++top
            --bottom
        }

        return res
    }
}
