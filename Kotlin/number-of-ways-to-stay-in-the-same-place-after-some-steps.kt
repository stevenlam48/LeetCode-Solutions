package numberofwaystostayinthesameplaceaftersomesteps

// Time:  O(n^2), n is the number of steps
// Space: O(n)

class Solution {
    fun numWays(steps: Int, arrLen: Int): Int {
        val mod = 1_000_000_007L
        val l = minOf(1 + steps / 2, arrLen)
        var dp = IntArray(l + 2)
        dp[1] = 1
        var remaining = steps
        while (remaining-- > 0) {
            val newDp = IntArray(l + 2)
            for (i in 1..l) {
                newDp[i] = ((dp[i].toLong() + dp[i - 1] + dp[i + 1]) % mod).toInt()
            }
            dp = newDp
        }
        return dp[1]
    }
}
