package encodestringwithshortestlength
// Time:  O(n^3) on average
// Space: O(n^2)

class Solution {
    fun encode(s: String): String {
        val dp = Array(s.length) { Array(s.length) { "" } }
        for (len in 1..s.length) {
            for (i in 0..s.length - len) {
                val j = i + len - 1
                dp[i][j] = s.substring(i, i + len)
                for (k in i until j) {
                    if (dp[i][k].length + dp[k + 1][j].length < dp[i][j].length) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j]
                    }
                }
                val encodedString = encodeSubstr(dp, s, i, j)
                if (encodedString.length < dp[i][j].length) {
                    dp[i][j] = encodedString
                }
            }
        }
        return dp[0][s.length - 1]
    }

    private fun encodeSubstr(dp: Array<Array<String>>, s: String, i: Int, j: Int): String {
        val temp = s.substring(i, j + 1)
        val pos = (temp + temp).indexOf(temp, 1)
        if (pos >= temp.length) {
            return temp
        }
        return (temp.length / pos).toString() + '[' + dp[i][i + pos - 1] + ']'
    }
}
