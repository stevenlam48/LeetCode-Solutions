package minimumchangestomakeksemipalindromes

// Time:  O(n * nlogn + n^3 + n^2 * k) = O(n^3)
// Space: O(n * nlogn) = O(n^2 * logn)

class Solution {
    fun minimumChanges(s: String, k: Int): Int {
        val n = s.length
        val divisors = Array(n + 1) { mutableListOf<Int>() }
        for (i in 1..n) {
            var j = i
            while (j <= n) {
                divisors[j].add(i)
                j += i
            }
        }
        val dp = Array(n) { Array(n) { HashMap<Int, Int>() } }
        for (l in 1..n) {
            for (left in 0..n - l) {
                val right = left + l - 1
                for (d in divisors[l]) {
                    var c = 0
                    for (i in 0 until d) {
                        if (s[left + i] != s[right - (d - 1) + i]) {
                            ++c
                        }
                    }
                    dp[left][right][d] = (if (left + d < right - d) dp[left + d][right - d][d] ?: 0 else 0) + c
                }
            }
        }
        val dp2 = Array(n) { IntArray(n) { n } }
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                var c = n
                for (d in divisors[j - i + 1]) {
                    if (d != j - i + 1) {
                        c = minOf(c, dp[i][j][d] ?: n)
                    }
                }
                dp2[i][j] = c
            }
        }
        var dp3 = IntArray(n + 1) { n }
        dp3[0] = 0
        repeat(k) { l ->
            val newDp3 = IntArray(n + 1) { n }
            for (i in 0 until n) {
                for (j in l * 2 until i) {
                    newDp3[i + 1] = minOf(newDp3[i + 1], dp3[j] + dp2[j][i])
                }
            }
            dp3 = newDp3
        }
        return dp3[n]
    }
}
