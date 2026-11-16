package longeststringchain
// Time:  O(n * l^2)
// Space: O(n * l)

class Solution {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        val dp = HashMap<String, Int>()
        for (word in words) {
            for (i in word.indices) {
                val predecessor = word.substring(0, i) + word.substring(i + 1)
                dp[word] = maxOf(dp.getOrDefault(word, 0), dp.getOrDefault(predecessor, 0) + 1)
            }
        }
        return dp.values.max()
    }
}
