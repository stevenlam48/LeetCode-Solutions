package countdifferentpalindromicsubsequences

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun countPalindromicSubsequences(s: String): Int {
        val p = 1_000_000_007
        val chars = "abcd"
        val n = s.length
        val dp = Array(3) { Array(n) { IntArray(4) } }
        for (len in 1..n) {
            for (i in 0..n - len) {
                for (c in chars) {
                    val ci = c - 'a'
                    dp[len % 3][i][ci] = 0
                    if (len == 1) {
                        dp[len % 3][i][ci] = if (s[i] == c) 1 else 0
                    } else {
                        if (s[i] != c) {
                            dp[len % 3][i][ci] = dp[(len - 1) % 3][i + 1][ci]
                        } else if (s[i + len - 1] != c) {
                            dp[len % 3][i][ci] = dp[(len - 1) % 3][i][ci]
                        } else {
                            var v = 2
                            if (len > 2) {
                                for (cc in chars) {
                                    v = (v + dp[(len - 2) % 3][i + 1][cc - 'a']) % p
                                }
                            }
                            dp[len % 3][i][ci] = v
                        }
                    }
                }
            }
        }
        var result = 0
        for (c in chars) {
            result = (result + dp[n % 3][0][c - 'a']) % p
        }
        return result
    }
}
