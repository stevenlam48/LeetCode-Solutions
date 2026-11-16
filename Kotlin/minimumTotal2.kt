package minimumTotal2

// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    fun minimumTotal(triangle: Array<IntArray>): Int {
        val N = triangle.size

        for (i in N - 2 downTo 0) {
            for (j in 0 until i + 1) {
                triangle[i][j] += minOf(triangle[i + 1][j], triangle[i + 1][j + 1])
            }
        }

        return triangle[0][0]
    }
}
