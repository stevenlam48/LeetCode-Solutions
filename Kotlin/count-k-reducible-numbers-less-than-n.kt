package countkreduciblenumberslessthann

// Time:  O(n^2)
// Space: O(n)

// dp
class Solution {
    fun countKReducibleNumbers(s: String, k: Int): Int {
        val MOD = 1_000_000_007
        while (s.length - 1 >= cnt.size) {
            cnt.add(cnt[Integer.bitCount(cnt.size)] + 1)
        }
        val dp = IntArray(s.length)
        var curr = 0
        for (i in s.indices) {
            for (j in i - 1 downTo 0) {
                dp[j + 1] = (dp[j + 1] + dp[j]) % MOD
            }
            if (s[i] != '1') {
                continue
            }
            dp[curr] = (dp[curr] + 1) % MOD
            ++curr
        }
        var result = 0
        for (i in 1 until s.length) {
            if (cnt[i] < k) {
                result = (result + dp[i]) % MOD
            }
        }
        return result
    }

    companion object {
        private val cnt = mutableListOf(0, 0)
    }
}
