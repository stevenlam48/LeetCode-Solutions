package concatenatedwords
// Time:  O(n * l^2)
// Space: O(n * l)

class Solution {
    fun findAllConcatenatedWordsInADict(words: List<String>): List<String> {
        val lookup = words.toHashSet()
        val result = mutableListOf<String>()
        for (word in words) {
            val dp = BooleanArray(word.length + 1)
            dp[0] = true
            for (i in word.indices) {
                if (!dp[i]) {
                    continue
                }
                for (j in i + 1..word.length) {
                    if (j - i < word.length && word.substring(i, j) in lookup) {
                        dp[j] = true
                    }
                }
                if (dp[word.length]) {
                    result.add(word)
                    break
                }
            }
        }
        return result
    }
}
