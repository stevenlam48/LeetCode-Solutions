package minimumwhitetilesaftercoveringwithcarpets

// Time:  O(m * n)
// Space: O(m * n)

// dp
class Solution {
    fun minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int {
        val dp = Array(floor.length + 1) { IntArray(numCarpets + 1) }
        for (i in 1..floor.length) {
            dp[i][0] = dp[i - 1][0] + if (floor[i - 1] == '1') 1 else 0
            for (j in 1..numCarpets) {
                dp[i][j] = minOf(
                    dp[i - 1][j] + if (floor[i - 1] == '1') 1 else 0,
                    dp[maxOf(i - carpetLen, 0)][j - 1]
                )
            }
        }
        return dp[floor.length][numCarpets]
    }
}
