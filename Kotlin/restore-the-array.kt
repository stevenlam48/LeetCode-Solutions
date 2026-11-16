package restorethearray

// Time:  O(nlogk)
// Space: O(logk)

class Solution {
    fun numberOfArrays(s: String, k: Int): Int {
        val MOD = 1_000_000_007
        val klen = k.toString().length
        val dp = IntArray(klen + 1)
        dp[s.length % dp.size] = 1
        for (i in s.length - 1 downTo 0) {
            dp[i % dp.size] = 0
            if (s[i] == '0') {
                continue
            }
            var j = i.toLong()
            var curr = 0L
            val limit = minOf(i.toLong() + klen, s.length.toLong())
            while (j < limit) {
                curr = curr * 10 + (s[j.toInt()] - '0')
                if (curr > k) {
                    break
                }
                dp[i % dp.size] = ((dp[i % dp.size].toLong() + dp[((j + 1) % dp.size).toInt()]) % MOD).toInt()
                ++j
            }
        }
        return dp[0]
    }
}
