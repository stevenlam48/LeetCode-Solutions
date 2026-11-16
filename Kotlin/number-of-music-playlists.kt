package numberofmusicplaylists
// Time:  O(n * l)
// Space: O(l)

class Solution {
    fun numMusicPlaylists(n: Int, l: Int, k: Int): Int {
        val mod = 1_000_000_007L
        val dp = Array(2) { LongArray(1 + l) }
        dp[0][0] = 1L
        dp[1][1] = 1L
        for (songs in 1..n) {
            dp[songs % 2][songs] = dp[(songs - 1) % 2][songs - 1] * songs % mod
            for (length in songs + 1..l) {
                dp[songs % 2][length] = (
                    dp[songs % 2][length - 1] * maxOf(songs - k, 0) % mod +
                        dp[(songs - 1) % 2][length - 1] * songs % mod
                    ) % mod
            }
        }
        return dp[n % 2][l].toInt()
    }
}
