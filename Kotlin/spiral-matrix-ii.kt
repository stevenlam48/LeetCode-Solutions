package spiralmatrixii

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }

        var num = 0
        var left = 0
        var right = n - 1
        var top = 0
        var bottom = n - 1
        while (left <= right && top <= bottom) {
            for (j in left..right) {
                matrix[top][j] = ++num
            }
            for (i in top + 1 until bottom) {
                matrix[i][right] = ++num
            }
            if (top < bottom) {
                for (j in right downTo left) {
                    matrix[bottom][j] = ++num
                }
            }
            if (left < right) {
                for (i in bottom - 1 downTo top + 1) {
                    matrix[i][left] = ++num
                }
            }
            ++left
            --right
            ++top
            --bottom
        }

        return matrix
    }
}
