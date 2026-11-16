package knightprobabilityinchessboard

// Time:  O(k * n^2)
// Space: O(n^2)

class Solution {
    fun knightProbability(N: Int, K: Int, r: Int, c: Int): Double {
        val directions = arrayOf(
            intArrayOf(1, 2), intArrayOf(1, -2), intArrayOf(2, 1), intArrayOf(2, -1),
            intArrayOf(-1, 2), intArrayOf(-1, -2), intArrayOf(-2, 1), intArrayOf(-2, -1)
        )
        val dp = Array(2) { Array(N) { DoubleArray(N) { 1.0 } } }
        for (step in 1..K) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    dp[step % 2][i][j] = 0.0
                    for (direction in directions) {
                        val rr = i + direction[0]
                        val cc = j + direction[1]
                        if (0 <= cc && cc < N && 0 <= rr && rr < N) {
                            dp[step % 2][i][j] += 0.125 * dp[(step - 1) % 2][rr][cc]
                        }
                    }
                }
            }
        }
        return dp[K % 2][r][c]
    }
}
