package decrementalstringconcatenation

// Time:  O(n)
// Space: O(1)
class Solution {
    fun minimizeConcatenatedLength(words: Array<String>): Int {
        var dp = Array(2) { IntArray(26) { Int.MIN_VALUE } }
        dp[0][words[0].last() - 'a'] = 0
        dp[1][words[0].first() - 'a'] = 0
        for (i in 1 until words.size) {
            val newDp = Array(2) { IntArray(26) { Int.MIN_VALUE } }
            for (right in 0 until 2) {
                for (c in 0 until 26) {
                    if (dp[right][c] == Int.MIN_VALUE) continue
                    val l = if (right != 0) c else words[i - 1].first() - 'a'
                    val r = if (right == 0) c else words[i - 1].last() - 'a'
                    newDp[0][r] = maxOf(newDp[0][r], dp[right][c] + if (words[i].last() - 'a' == l) 1 else 0)
                    newDp[1][l] = maxOf(newDp[1][l], dp[right][c] + if (r == words[i].first() - 'a') 1 else 0)
                }
            }
            dp = newDp
        }
        val total = words.sumOf { it.length }
        var mx = 0
        for (right in 0 until 2) {
            for (c in 0 until 26) {
                mx = maxOf(mx, dp[right][c])
            }
        }
        return total - mx
    }
}
