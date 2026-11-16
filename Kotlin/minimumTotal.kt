package minimumTotal

// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    fun minimumTotal(triangle: Array<IntArray>): Int {
        val N = triangle.size
        val f = IntArray(N) { Int.MAX_VALUE }
        var ans = Int.MAX_VALUE

        f[0] = triangle[0][0]
        for (i in 1 until N) {
            for (j in i downTo 1) {
                f[j] = minOf(f[j], f[j - 1]) + triangle[i][j]
            }
            f[0] += triangle[i][0]
        }

        for (i in 0 until N) {
            ans = minOf(ans, f[i])
        }

        return ans
    }
}
