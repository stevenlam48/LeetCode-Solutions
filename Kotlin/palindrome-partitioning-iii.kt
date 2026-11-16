package palindromepartitioningiii
// Time:  O(k * n^2)
// Space: O(n^2)

class Solution {
    fun palindromePartition(s: String, k: Int): Int {
        val dp1 = Array(s.length) { IntArray(s.length) }
        for (l in 1..s.length) {
            for (i in 0..s.length - l) {
                val j = i + l - 1
                if (i == j - 1) {
                    dp1[i][j] = if (s[i] == s[j]) 0 else 1
                } else if (i != j) {
                    dp1[i][j] = if (s[i] == s[j]) dp1[i + 1][j - 1] else dp1[i + 1][j - 1] + 1
                }
            }
        }
        val dp2 = Array(2) { IntArray(s.length) { Int.MAX_VALUE } }
        dp2[1] = dp1[0]
        for (d in 2..k) {
            dp2[d % 2] = IntArray(s.length) { Int.MAX_VALUE }
            for (i in d - 1 until s.length) {
                for (j in d - 2 until i) {
                    dp2[d % 2][i] = minOf(dp2[d % 2][i], dp2[(d - 1) % 2][j] + dp1[j + 1][i])
                }
            }
        }
        return dp2[k % 2][s.length - 1]
    }
}
