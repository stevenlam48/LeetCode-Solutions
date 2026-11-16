package numberofpathswithmaxscore

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun pathsWithMaxScore(board: List<String>): IntArray {
        val mod = 1_000_000_007
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(1, 1))
        val dp = Array(2) { Array(board[0].length + 1) { IntArray(2) } }
        dp[(board.size - 1) % 2][board[0].length - 1] = intArrayOf(0, 1)
        for (r in board.size - 1 downTo 0) {
            for (c in board[0].length - 1 downTo 0) {
                if (board[r][c] == 'S' || board[r][c] == 'X') {
                    continue
                }
                dp[r % 2][c] = intArrayOf(0, 0)
                for ((dr, dc) in directions) {
                    val next = dp[(r + dr) % 2][c + dc]
                    if (dp[r % 2][c][0] < next[0]) {
                        dp[r % 2][c] = next.copyOf()
                    } else if (dp[r % 2][c][0] == next[0]) {
                        dp[r % 2][c][1] = (dp[r % 2][c][1] + next[1]) % mod
                    }
                }
                if (dp[r % 2][c][1] != 0 && board[r][c] != 'E') {
                    dp[r % 2][c][0] += board[r][c] - '0'
                }
            }
        }
        return dp[0][0]
    }
}
