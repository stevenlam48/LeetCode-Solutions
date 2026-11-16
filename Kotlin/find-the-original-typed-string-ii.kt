package findtheoriginaltypedstringii
// Time:  O(n + k^2)
// Space: O(n + k)

class Solution {
    fun possibleStringCount(word: String, k: Int): Int {
        val MOD = 1_000_000_007

        val cnt = mutableListOf(0)
        for (i in word.indices) {
            ++cnt[cnt.lastIndex]
            if (i + 1 == word.length || word[i + 1] != word[i]) {
                cnt.add(0)
            }
        }
        cnt.removeAt(cnt.lastIndex)
        var result = 1L
        for (x in cnt) {
            result = (result * x) % MOD
        }
        if (k <= cnt.size) {
            return result.toInt()
        }
        val dp = IntArray(k - cnt.size)
        dp[0] = 1
        for (l in cnt) {
            for (i in 0 until dp.lastIndex) {
                dp[i + 1] = (dp[i + 1] + dp[i]) % MOD
            }
            for (i in dp.lastIndex downTo l) {
                dp[i] = ((dp[i] - dp[i - l]) % MOD + MOD) % MOD
            }
        }
        var sum = 0
        for (x in dp) {
            sum = (sum + x) % MOD
        }
        return (((result - sum) % MOD + MOD) % MOD).toInt()
    }
}
