package numberofwaystoformatargetstringgivenadictionary

// Time:  O(l * (w + n)), l is the length of a word, w is the number of words, n is the length of target
// Space: O(n)

class Solution {
    fun numWays(words: List<String>, target: String): Int {
        val mod = 1_000_000_007L
        val dp = LongArray(target.length + 1)
        dp[0] = 1L
        for (i in words[0].indices) {
            val count = IntArray(26)
            for (word in words) {
                ++count[word[i] - 'a']
            }
            for (j in target.lastIndex downTo 0) {
                dp[j + 1] += dp[j] * count[target[j] - 'a'] % mod
            }
        }
        return (dp[target.length] % mod).toInt()
    }
}
