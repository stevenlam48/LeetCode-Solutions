package countpalindromicsubsequences

// Time:  O(10^(l/2) * n), l = 5
// Space: O(10^(l/2) * n)

// freq table, prefix sum
class Solution {
    fun countPalindromes(s: String): Int {
        val MOD = 1_000_000_007L
        val cnt = IntArray(10)
        val left = Array(s.length + 1) { Array(10) { LongArray(10) } }
        for (k in s.indices) {
            for (i in 0 until 10) {
                left[k][i].copyInto(left[k + 1][i])
            }
            val d = s[k] - '0'
            for (i in 0 until 10) {
                left[k + 1][d][i] += cnt[i]
            }
            ++cnt[d]
        }
        cnt.fill(0)
        val right = Array(10) { LongArray(10) }
        var result = 0L
        for (k in s.length - 1 downTo 0) {
            for (i in 0 until 10) {
                for (j in 0 until 10) {
                    result = (result + left[k][i][j] * right[i][j]) % MOD
                }
            }
            val d = s[k] - '0'
            for (i in 0 until 10) {
                right[d][i] += cnt[i]
            }
            ++cnt[d]
        }
        return result.toInt()
    }
}
